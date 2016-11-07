/*   
 * Copyright (c) 2016-2026 Founder Bdong. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Founder.   
 *   
 */     
package org.app.management.service.impl;

import org.app.base.common.GlobalConfig;
import org.app.base.common.Pagination;
import org.app.base.common.utils.*;
import org.app.base.domain.*;
import org.app.base.domain.query.UserQuery;
import org.app.base.domain.vo.UserVO;
import org.app.base.service.IAdultVideoStarService;
import org.app.base.service.IGroupService;
import org.app.base.service.IUserService;
import org.app.management.service.ILogService;
import org.app.management.service.ILoginService;
import org.app.management.service.LoginUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * 登录业务层实现
 * This class is used for ...   
 * @author Bdong  
 * @version   
 *       1.0, 2016年9月24日 下午7:18:24
 */
@Service("loginServiceImpl")
public class LoginServiceImpl implements ILoginService {
	@Resource(name="userServiceImpl")
	private IUserService userServiceImpl;
	@Resource(name="avStarServiceImpl")
	private IAdultVideoStarService avStarServiceImpl;
	@Resource(name="groupServiceImpl")
	private IGroupService groupServiceImpl;
	@Resource(name="logServiceImpl")
	private ILogService logServiceImpl;
	
	public UserVO login(UserQuery userQ, HttpServletRequest request) throws Exception {
		
		// TODO Auto-generated method stub
		UserVO userVO = selectByName(userQ.getUsername());
		if(userVO==null){
			userVO = new UserVO();
			userVO.setReturnInfo("不存在该用户！");
			return userVO;
		}

		LoginBad BadUser = LoginUtils.getUserbadloginmap().get(userVO.getUsername());
		if(BadUser!=null){
			Date d1 =BadUser.getLastDate();
			if(LoginUtils.getUserCount(userVO.getUsername())>=5&&
					DateUtils.compareDateWithNow(d1.getTime()+5*60*1000)==-1){
				userVO.setReturnInfo("用户连续认证失败5次,限制登录5分钟！");
				return userVO;
			}
		}
		String realIP=IPUtils.getIpAddress(request);
		LoginBad BadIp = LoginUtils.getIpbadloginmap().get(realIP);
		if(BadIp!=null){
			Date d2 =BadIp.getLastDate();
			if(LoginUtils.getIpCount(realIP)>=6&&
					DateUtils.compareDateWithNow(d2.getTime()+5*60*1000)==-1){
				userVO.setReturnInfo("IP连续认证失败6次,限制登录5分钟！");
				return userVO;
			}
		}
		UserVO userVOSession =(UserVO) request.getSession().getAttribute("userVO");
		//IP合法
		if(isIPSafe(userVO,realIP)){
			//加密后的密码
			String desPassWord = new String(DesUtils.encrypt(userQ.getPassword().getBytes(),DesUtils.getPassword()));
			//session中的密码
			if(userVOSession!=null&&userQ.getPassword().equals(userVOSession.getPassword())){
				StringBuilder groupCodePath = new StringBuilder();
				StringBuilder groupNamePath = new StringBuilder();
				UserVO userVOTemp =setGroupPath(userVO.getGid(),userVO,groupCodePath,groupNamePath);
				userVO.setGroupCodePath(userVOTemp.getGroupCodePath());
				userVO.setGroupNamePath(userVOTemp.getGroupNamePath());
				userVO.setReturnInfo("true");
				userVO.setLoginDate(DateUtils.getNowTime());
				userVO.setLoginUrl("welcome");
				request.getSession().setAttribute("userVO", userVO);
			}else if(desPassWord.equals(userVO.getPassword())){
				StringBuilder groupCodePath = new StringBuilder();
				StringBuilder groupNamePath = new StringBuilder();
				UserVO userVOTemp =setGroupPath(userVO.getGid(),userVO,groupCodePath,groupNamePath);
				userVO.setGroupCodePath(userVOTemp.getGroupCodePath());
				userVO.setGroupNamePath(userVOTemp.getGroupNamePath());
				userVO.setReturnInfo("true");
				userVO.setLoginDate(DateUtils.getNowTime());
				userVO.setLoginUrl("welcome");
				request.getSession().setAttribute("userVO", userVO);
				LoginUtils.removeLoginCount(userVO.getUsername(), realIP);
				SessionUtils.putSession(userVO.getUsername(), request.getSession());
			}else{
				//密码错误
				userVO.setPassword("");;//清空数据
				userVO.setReturnInfo("尊敬的用户，您的密码错误，请重新输入！");
				LoginUtils.addLoginBadCount(userVO.getUsername(),realIP);
			}
		}else{
			//IP不合法
			userVO.setReturnInfo("IP不合法！");
			LoginUtils.addLoginBadCount(userVO.getUsername(),realIP);
		}
		Log log =new Log();
		log.setId(String.valueOf(System.currentTimeMillis()));
		log.setUserid(userVO.getId());
		log.setIp(realIP);
		log.setUsername(userVO.getUsername());
		log.setPassword(userVO.getPassword());
		log.setRemark(userVO.getReturnInfo());
		log.setOperateDate(new Date());
		if(userVOSession==null){
			logServiceImpl.insertSelective(log);
		}
		return userVO;
	}
	
	public String loginVerify(UserQuery userQ, HttpServletRequest request)
			throws Exception {
		// TODO Auto-generated method stub
		UserVO userVO = selectByName(userQ.getUsername());
		if(userVO==null){
			return "输入的用户名不存在，请核对后重新登录！";
		}
		//获取用户IP
		String realIP=IPUtils.getIpAddress(request);
		//IP校验
		if(isIPSafe(userVO,realIP)){
			if(userQ.getPassword().equals(userVO.getPassword())){
				//密码正确，将用户名存入session
				request.getSession().setAttribute(GlobalConfig.sessionKey, userQ.getUsername());
				return "true";
			}else{
				//密码错误
				return "尊敬的用户，输入的密码错误，请核对后重新登录！";
			}
		}else{
			//IP不合法
			return "IP不合法！";
		}
	}
	
	public UserVO getUserInfo(String username)
			throws Exception {
		UserVO userVO =selectByName(username);
		StringBuilder groupCodePath = new StringBuilder();
		StringBuilder groupNamePath = new StringBuilder();
		UserVO userVOTemp =setGroupPath(userVO.getGid(),userVO,groupCodePath,groupNamePath);
		userVO.setGroupCodePath(userVOTemp.getGroupCodePath());
		userVO.setGroupNamePath(userVOTemp.getGroupNamePath());
		userVO.setReturnInfo("true");
		userVO.setLoginDate(DateUtils.getNowTime());
		userVO.setLoginUrl("welcome");
		return userVO;
	}
	
	public UserVO repasswd(UserQuery userQ,HttpServletRequest request) throws Exception {
		UserVO userVO = selectByName(userQ.getUsername());
		if(userVO==null){
			userVO =new UserVO();
			userVO.setReturnInfo("不存在该用户！");
			return userVO;
		}
		String realIP=IPUtils.getIpAddress(request);
		//IP合法
		if (isIPSafe(userVO, realIP)) {
			// 密码解密
			String desPassWord = new String(DesUtils.encrypt(userQ
					.getPasswordOld().getBytes(), DesUtils.getPassword()));
			// 密码正确
			if (desPassWord.equals(userVO.getPassword())) {
				String verfyResult =RegExpUtils.verify(userQ.getPasswordNew());
				//新密码强度校验
				if("true".equals(verfyResult)){
					//新密码加密
					String desPassNew = new String(DesUtils.encrypt(userQ.getPasswordNew().getBytes(),DesUtils.getPassword()));
					userQ.setId(userVO.getId());
					userQ.setPassword(desPassNew);
					//更新密码
					if(updateByPrimaryKeySelective(userQ)==1){
						userVO.setReturnInfo("密码更新成功！");
					}else{
						userVO.setReturnInfo("密码更新失败！");
					}
				}else{
					userVO.setReturnInfo(verfyResult);
				}
			} else {
				// 密码错误
				userVO = new UserVO();// 清空数据
				userVO.setReturnInfo("尊敬的用户，旧密码错误，请重新输入！");
			}
		} else {
			// IP不合法
			userVO.setReturnInfo("IP不合法！");
		}
		return userVO;
	}
	
	/**
	 * 判断IP是否合法
	 * @param user
	 * @param realIP
	 * @return  
	 * @author Bdong
	 */
	private Boolean isIPSafe(User user, String realIP){
		Boolean flag=false;
		if(user.getEnableIp()!=null&&user.getEnableIp()!=""){
			String[] enableIps=user.getEnableIp().split("\\|");
			for(String enableIp:enableIps){
				if(enableIp.equals(realIP)){
					flag=true;
				}
			}
		}else{
			flag=true;
		}
		return flag;
	}
	
	
	private UserVO setGroupPath(String id,UserVO userVO,StringBuilder groupCodePath,StringBuilder groupNamePath){
		Group group = selectByPrimaryKey(id);
		if(group.getPid()!=null&&!"".equals(group.getPid())&&!"1".equals(group.getPid())){
			groupCodePath.insert(0, "/"+group.getId());
			groupNamePath.insert(0, "/"+group.getName());  
			setGroupPath(group.getPid(),userVO,groupCodePath,groupNamePath);
		}
		userVO.setGroupCodePath(groupCodePath.toString());
		userVO.setGroupNamePath(groupNamePath.toString());
		return userVO;
	}
	
	public UserVO selectByName(String username) {
		// TODO Auto-generated method stub
		return userServiceImpl.selectByName(username);
	}

	public Group selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return groupServiceImpl.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(User record) {
		// TODO Auto-generated method stub
		return userServiceImpl.updateByPrimaryKeySelective(record);
	}

	public List<AdultVideoStar> selectAllAVStar() {
		// TODO Auto-generated method stub
		return avStarServiceImpl.selectAll();
	}

	public Pagination<AdultVideoStar> getAVStarInfo(int pageIndex, int pageSize, boolean flag) {
		List<AdultVideoStar> listAdultVideoStar = selectAllAVStar();
		Pagination<AdultVideoStar> pagination=new Pagination<AdultVideoStar>(pageIndex,pageSize,listAdultVideoStar,flag);
		return pagination;
	}


}
  