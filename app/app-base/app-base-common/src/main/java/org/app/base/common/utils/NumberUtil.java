package org.app.base.common.utils;



public class NumberUtil {

    /**
     * 解析解析为int 如不能解析默认为0
     * @param obj 解析值
     * @return 返回结果
     */
    public static int objectToInt(Object obj) {
        return objectToInt(obj, 0);
    }


    /**
     * 解析解析为int
     * @param obj 解析值
     * @param defaultValue 不能解析时的默认值
     * @return 返回结果
     */
    public static int objectToInt(Object obj, int defaultValue) {
        try {
            return Integer.parseInt(String.valueOf(obj));
        } catch (NumberFormatException nfe) {
            return defaultValue;
        }
    }


}
