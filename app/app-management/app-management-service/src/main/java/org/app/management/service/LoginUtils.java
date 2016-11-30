package org.app.management.service;

import org.app.base.common.utils.NumberUtil;
import org.app.base.common.utils.StringUtils;
import org.app.base.domain.LoginBad;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录限制工具类
 */
public class LoginUtils {

    private static final Map<String, LoginBad> userBadLoginMap = new HashMap<String, LoginBad>();
    private static final Map<String, LoginBad> ipBadLoginMap = new HashMap<String, LoginBad>();


    /**
     * 添加用户登录失败的次数
     *
     * @param user
     * @param ip
     */
    public static void addLoginBadCount(String user, String ip) {
        LoginBad userLoginRestrict = getLoginBadByUser(user);
        LoginBad IPLoginRestrict = getLoginBadByIP(ip);

        //记录最新的失败时间
        Date date = new Date();
        userLoginRestrict.setLastDate(date);
        IPLoginRestrict.setLastDate(date);
        //记录新的失败次数
        userLoginRestrict.setCount(userLoginRestrict.getCount() + 1);
        IPLoginRestrict.setCount(IPLoginRestrict.getCount() + 1);


    }

    /**
     * 通过用户获得限制信息
     *
     * @param username
     * @return
     */
    public static LoginBad getLoginBadByUser(String username) {
        LoginBad loginRestrict = getUserbadloginmap().get(username);
        if (loginRestrict == null) {
            loginRestrict = new LoginBad();
            getUserbadloginmap().put(username, loginRestrict);
        }

        return loginRestrict;
    }

    /**
     * 通过ip获得限制信息
     *
     * @param ip
     * @return
     */
    public static LoginBad getLoginBadByIP(String ip) {
        LoginBad loginRestrict = getIpbadloginmap().get(ip);
        if (loginRestrict == null) {
            loginRestrict = new LoginBad();
            getIpbadloginmap().put(ip, loginRestrict);
        }

        return loginRestrict;
    }


    /**
     * 通过用户获取登录失败的次数
     *
     * @param user
     * @return
     */
    public static int getUserCount(String user) {
        return NumberUtil.objectToInt(getLoginBadByUser(user).getCount());
    }

    /**
     * 通过ip获取登录失败的次数
     *
     * @param ip
     * @return
     */
    public static int getIpCount(String ip) {
        return NumberUtil.objectToInt(getLoginBadByIP(ip).getCount());
    }

    /**
     * 删除用户和ip的失败次数
     *
     * @param user 用户
     * @param ip   ip
     */
    public static void removeLoginCount(String user, String ip) {
        getUserbadloginmap().remove(user);
        getIpbadloginmap().remove(ip);
    }


    /**
     * 验证用户密码强度
     *
     * @param password
     * @return
     */
    public static boolean checkPassWordStrong(String password) {
        if (StringUtils.isBlank(password) || password.length() < 12) {
            return false;
        }
        int passNum = 0;
        //验证是否存在数字
        if (password.matches(".*\\d.*")) {
            passNum++;
        }
        //验证是否存在小写字母
        if (password.matches(".*[a-z].*")) {
            passNum++;
        }
        //验证是否存在大写字母
        if (password.matches(".*[A-Z].*")) {
            passNum++;
        }
        //是否存在特殊字符
        if (password.matches(".*\\W.*")) {
            passNum++;
        }
        return passNum >= 3;
    }

    public static Map<String, LoginBad> getUserbadloginmap() {
        return userBadLoginMap;
    }

    public static Map<String, LoginBad> getIpbadloginmap() {
        return ipBadLoginMap;
    }

}
