package org.app.base.common.utils;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

public class SessionUtils {

    //存放用户的登录session 
    private static Map<String, HttpSession> sessionMap = new HashMap<String, HttpSession>();

    /**
     * 存放用户session 并删除旧的用户的登录状态
     * @param userName  用户名
     * @param session  新用户的session
     */
    public static void putSession(String userName, HttpSession session) {
        HttpSession oldSession = sessionMap.get(userName);
        if (oldSession != null) {
        	removeAllSession(oldSession);
        }
        sessionMap.put(userName, session);
    }

    /**
     * 清空session
     * @param session
     */
    public static void  removeAllSession(HttpSession session){
        Enumeration<String> names= session.getAttributeNames();
        while (names.hasMoreElements()){
            session.removeAttribute(names.nextElement());
        }

    }

	public static Map<String, HttpSession> getSessionMap() {
		return sessionMap;
	}

	public static void setSessionMap(Map<String, HttpSession> sessionMap) {
		SessionUtils.sessionMap = sessionMap;
	}
}
