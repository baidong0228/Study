package org.app.base.common.utils;

public class StringUtils {
    public static final String EMPTY = ""; //空字符串

    /**
     * 判断字符串是否是空
     *
     * @param str
     * @return
     * @date 2016年9月24日
     * @version 1.0.0
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    /**
     * 判断是否是无意义的字符串
     *
     * @param str
     * @return 返回
     * @date 2016年9月24日
     * @version 1.0.0
     */
    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }
}
