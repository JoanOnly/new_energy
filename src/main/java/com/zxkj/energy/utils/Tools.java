package com.zxkj.energy.utils;

import java.io.File;
import java.io.IOException;

/**
 * 工具类
 */
public class Tools {
    /**
     * 方法描述：获取项目主目录 如：C:\Users\kmzx\Projects\new_energy
     * 创建时间：2019-06-19 09:38:59
     * 创建作者：刘万琼
     *
     * @return the string按时发达双方都
     * @throws IOException the io exception
     */
    public static String directory() throws IOException {
        return new File("").getCanonicalPath();
    }

    /**
     * 方法描述：自定义判断是否为空
     * 创建作者：李兴武
     * 创建日期：2017-06-22 19:50:01
     *
     * @param str the str
     * @return the boolean
     * @author "lixingwu"
     */
    public static Boolean isBlank(String str) {
        if (str != null) {
            str = str.replaceAll("\r\n|\n\r|\n|\r|\f|\t", "");
        }
        if (str == null) {
            return true;
        } else if ("".equals(str)) {
            return true;
        } else if ("null".equals(str)) {
            return true;
        } else if ("NULL".equals(str)) {
            return true;
        } else if ("(null)".equals(str)) {
            return true;
        } else if ("(NULL)".equals(str)) {
            return true;
        } else if (str.trim().length() == 0) {
            return true;
        }
        return false;
    }

    /**
     * 方法描述：判断obj是否为空
     * 创建作者：李兴武
     * 创建日期：2017-06-22 19:50:01
     *
     * @param obj the 判断的对象
     * @return the boolean
     * @author "lixingwu"
     */
    public static Boolean isBlank(Object obj) {
        if (obj != null) {
            return isBlank(String.valueOf(obj));
        }
        return true;
    }
}
