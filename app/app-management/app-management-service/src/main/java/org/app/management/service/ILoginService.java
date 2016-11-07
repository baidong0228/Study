/*   
 * Copyright (c) 2016-2026 Founder Bdong. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Founder.   
 *   
 */     
package org.app.management.service;


import org.app.base.common.Pagination;
import org.app.base.domain.AdultVideoStar;
import org.app.base.domain.Group;
import org.app.base.domain.User;
import org.app.base.domain.query.UserQuery;
import org.app.base.domain.vo.UserVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 登录业务层
 * This class is used for ...   
 * @author Bdong  
 * @version   
 *       1.0, 2016年9月24日 下午7:15:29
 */
public interface ILoginService {
	/**
	 * 登录主逻辑
	 * @param userQ
	 * @return  
	 * @author Bdong
	 */
	public UserVO login(UserQuery userQ, HttpServletRequest request) throws Exception;
	
	/**
	 * 登录校验
	 * @param userQ
	 * @return  
	 * @author Bdong
	 */
	public String loginVerify(UserQuery userQ, HttpServletRequest request) throws Exception;
	
	/**
	 * 获取用户信息
	 * @param username
	 * @return  
	 * @author Bdong
	 */
	public UserVO getUserInfo(String username) throws Exception;
	
	/**
	 * 修改密码
	 * @param userQ
	 * @return
	 * @throws Exception  
	 * @author Bdong
	 */
	public UserVO repasswd(UserQuery userQ, HttpServletRequest request) throws Exception;
	
	/**
	 * 根据用户名查询用户信息
	 * @param username
	 * @return  
	 * @author Bdong
	 */
	public UserVO selectByName(String username);
	
	/**
	 * 根据Id查询
	 * @param id
	 * @return  
	 * @author Bdong
	 */
	public Group selectByPrimaryKey(String id);
	
	/**
	 * 更新
	 * @param record
	 * @return  
	 * @author Bdong
	 */
	public int updateByPrimaryKeySelective(User record);
	
	/**
	 * 查询所有AVstar
	 * @return
	 * @author Bdong
	 */
	public List<AdultVideoStar> selectAllAVStar();
	
	/**
	 * 得到AVStar分页信息
	 * @return  
	 * @author Bdong
	 */
	public Pagination<AdultVideoStar> getAVStarInfo(int pageIndex, int pageSize, boolean flag);
}
  