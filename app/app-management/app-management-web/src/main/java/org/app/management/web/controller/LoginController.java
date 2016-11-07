/*   
 * Copyright (c) 2016-2026 Founder Bdong. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Founder.   
 *   
 */    

package org.app.management.web.controller;

import org.apache.log4j.Logger;
import org.app.base.common.GlobalConfig;
import org.app.base.domain.query.UserQuery;
import org.app.management.service.ILoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 登录
 * This class is used for ...   
 * @author Bdong  
 * @version   
 *       1.0, 2016年9月24日 下午4:58:29
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {
	private static Logger logger = Logger.getLogger(LoginController.class);
	private static final String loginPath="redirect:/controller/loginIndex";
	private static final String welcomePath="redirect:/controller/user/welcome";
	@Resource(name="loginServiceImpl")
	private ILoginService loginServiceImpl;
	
	@RequestMapping("loginIndex")
    public  String loginIndex(HttpServletRequest request){ 
		return "login";
	}
	
	/**
	 * 登录
	 * @param request
	 * @param userQ
	 * @return  
	 * @author Bdong
	 */
	@RequestMapping("login")
    public ModelAndView login(HttpServletRequest request, UserQuery userQ){
		ModelAndView mav = new ModelAndView();
		try {
			//获取session中的username
			String username=(String) request.getSession().getAttribute(GlobalConfig.sessionKey);
			if(username!=null){
				//已经登录，跳转至welcome
				mav.setViewName(welcomePath);
			}else{
				//没有登录
				//登录校验
				String loginInfo =loginServiceImpl.loginVerify(userQ, request);
				if("true".equals(loginInfo)){
					//成功，跳转到welcom
					mav.setViewName(welcomePath);
				}else{
					//失败，跳转到登录页面
					mav.addObject("loginInfo",loginInfo);
					mav.setViewName("login");
				}
			}
			return mav;
		} catch (Exception e) {
			logger.error("登录异常：", e);
			mav.setViewName("redirct:"+GlobalConfig.error500); 
			return mav;
		}
	}
	
	/**
	 * 登出
	 * @param request
	 * @param model
	 * @return  
	 * @author Bdong
	 */
	@RequestMapping("logOut")
    public String logOut(HttpServletRequest request,Model model){
		try{
			//删除session中的凭证
			request.getSession().removeAttribute(GlobalConfig.sessionKey);
			//跳转
			return loginPath;
		}catch(Exception e){
			logger.error("登出异常：", e);
			return "redirect:"+GlobalConfig.error500;
		}
	}
	
}
  