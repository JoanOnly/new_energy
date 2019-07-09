package com.zxkj.energy.system.application;

import cn.hutool.core.util.CharsetUtil;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

/**
 * 读取application等 自定义配置文件
 *
 * @author 刘万琼
 */
public class ApplicationUtil {
    // 加载类ApplicationUtil的时候就实例化
    private static ApplicationUtil custom = new ApplicationUtil();
    private Object object;
    private Object objectActive;

    /**
     * 方法描述：初始化
     * 创建时间：2019-07-02 15:01:42
     * 创建作者：刘万琼
     */
    private ApplicationUtil() {
        Yaml yaml = new Yaml();
        InputStream in = ApplicationUtil.class.getClassLoader().getResourceAsStream("application.yml");
        InputStreamReader reader = new InputStreamReader(in, CharsetUtil.CHARSET_UTF_8);
        object = yaml.load(reader);
        Object active = getParam("spring.profiles.active", object);
        InputStream inActive = ApplicationUtil.class.getClassLoader().getResourceAsStream("application-" + active + ".yml");
        InputStreamReader readerActive = new InputStreamReader(inActive, CharsetUtil.CHARSET_UTF_8);
        objectActive = yaml.load(readerActive);
    }

    /**
     * 方法描述：单例 保证单例的唯一性
     * <p> 获取唯一可用的对象
     * 创建时间：2019-07-02 15:01:42
     * 创建作者：刘万琼
     *
     * @return the ApplicationUtil 防止custom太久不用被虚拟机销毁，
     * 所以为了程序的严谨，继续判断是否为null，是则重新创建一个
     */
    public static ApplicationUtil getInstance() {
        if (custom == null) {
            custom = new ApplicationUtil();
        }
        return custom;
    }

    /**
     * 方法描述：根据配置文件属性名去获取值
     * 创建时间：2019-07-02 15:48:53
     * 创建作者：刘万琼
     *
     * @param name the name
     * @return the object
     */
    private Object getParam(String name, Object object) {
        String[] split = name.split("\\.");
        LinkedHashMap linked;
        for (String param : split) {
            // 判断object是否能够转化为LinkedHashMap（因为object不能直接get（）获取属性）
            if (object instanceof LinkedHashMap) {
                linked = (LinkedHashMap) object;
                object = linked.get(param);
            }
        }
        return object;
    }

    /**
     * 方法描述：根据配置文件属性名去获取值
     * 创建时间：2019-07-02 16:04:33
     * 创建作者：刘万琼
     *
     * @param name the name
     * @return the Object 如果主配置文件没有就去副配置文件找
     */
    public Object getProperty(String name) {
        Object param = getParam(name, object);
        if (param == null) {
            param = getParam(name, objectActive);
        }
        return param;
    }
}
