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
import org.app.base.common.Pagination;
import org.app.base.domain.AdultVideoStar;
import org.app.base.domain.query.UserQuery;
import org.app.base.domain.vo.UserVO;
import org.app.management.service.ILoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 用户管理
 * This class is used for ...
 *
 * @author Bdong
 * @version 1.0, 2016年9月30日 上午11:28:18
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    private static Logger logger = Logger.getLogger(UserController.class);

    @Resource(name = "loginServiceImpl")
    private ILoginService loginServiceImpl;

    /**
     * 用户信息界面
     *
     * @param request
     * @return
     * @author Bdong
     */
    @RequestMapping("welcome")
    public ModelAndView welcome(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        try {
            String username = (String) request.getSession().getAttribute(GlobalConfig.sessionKey);
            mav.addObject(loginServiceImpl.getUserInfo(username));
            mav.setViewName("welcome");
            return mav;
        } catch (Exception e) {
            logger.error("用户信息异常：", e);
            mav.setViewName(GlobalConfig.error500);
            return mav;
        }
    }

    @RequestMapping("repasswd")
    public
    @ResponseBody
    UserVO repasswd(HttpServletRequest request, UserQuery userQ) {
        try {
            return loginServiceImpl.repasswd(userQ, request);
        } catch (Exception e) {
            logger.error("密码修改异常：", e);
            return null;
        }
    }

    @RequestMapping("kimoji")
    public
    @ResponseBody
    Pagination<AdultVideoStar> getKimoji(HttpServletRequest request, int pageIndex, int pageSize) {
        try {
            return loginServiceImpl.getAVStarInfo(pageIndex, pageSize, true);
        } catch (Exception e) {
            logger.error("密码修改异常：", e);
            return null;
        }
    }
}
  