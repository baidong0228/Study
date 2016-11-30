/*   
 * Copyright (c) 2016-2026 Founder Bdong. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Founder.   
 *   
 */
package org.app.management.web.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录过滤器
 * This class is used for ...
 *
 * @author Bdong
 * @version 1.0, 2016年9月29日 上午11:39:03
 */
public class LoginFilter implements Filter {

    private FilterConfig config;

    public void init(FilterConfig filterConfig) throws ServletException {
        config = filterConfig;
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();

        //从配置文件中获取不需要过滤的路径(登录相关)
        String noLoginPaths = config.getInitParameter("noLoginPaths");

        //检索不需要过滤的路径，如果是则放行
        if (noLoginPaths != null) {
            String[] strArray = noLoginPaths.split(";");
            for (int i = 0; i < strArray.length; i++) {

                if (strArray[i] == null || "".equals(strArray[i])) continue;

                if (req.getRequestURI().indexOf(strArray[i]) != -1) {
                    chain.doFilter(req, resp);
                    return;
                }
            }

        }

        // 从session取得已经登录验证的凭证 
        if (session.getAttribute("username") != null) {
            //已经登陆,继续此次请求
            chain.doFilter(req, resp);
        } else {
            //未登录，跳转到登录页面
            resp.sendRedirect(req.getContextPath() + "/controller/login/loginIndex");
        }
    }

    public void destroy() {

    }

}
  