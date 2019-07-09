package com.zxkj.energy.generator;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 刘万琼
 */
public class CustomCode {

    /**
     * 方法描述：Copy service.
     * 创建时间：2019-06-19 15:09:52
     * 创建作者：刘万琼
     *
     * @param param the param
     */
    public static void copyService(GeneratorParam param) {
        // 获取项目主目录
        String directory = param.getDirectory();
        // 模板源文件地址
        String source = directory + "\\src\\main\\resources\\templates\\TemplateService.java";
        // 目的地文件地址
        String destination = directory + "\\src\\main\\java\\" + param.getPackageUrl() + "\\service\\";
        destination += param.getFolderName() + "\\" + param.getClassName() + "Service.java";
        // 将源文件复制到目的地
        FileUtil.copy(source, destination, true);
        // 将目的地文件的参数替换掉
        String content = FileUtil.readUtf8String(destination);
        FileUtil.writeUtf8String(replaceContent(content, param(param)), destination);
    }

    /**
     * 方法描述：Copy controller.
     * 创建时间：2019-06-19 15:09:46
     * 创建作者：刘万琼
     *
     * @param param the param
     */
    public static void copyController(GeneratorParam param) {
        String directory = param.getDirectory();
        String source = directory + "\\src\\main\\resources\\templates\\TemplateController.java";
        String destination = directory + "\\src\\main\\java\\" + param.getPackageUrl() + "\\controller\\";
        destination += param.getFolderName() + "\\" + param.getClassName() + "Ctl.java";
        FileUtil.copy(source, destination, true);
        String content = FileUtil.readUtf8String(destination);
        FileUtil.writeUtf8String(replaceContent(content, param(param)), destination);
    }

    /**
     * 方法描述：替换文件内容
     * 创建时间：2019-06-19 14:32:32
     * 创建作者：刘万琼
     *
     * @param content the content
     * @return the string
     */
    private static String replaceContent(String content, Map<String, Object> param) {
        for (Map.Entry<String, Object> map : param.entrySet()) {
            content = content.replace(map.getKey(), String.valueOf(map.getValue()));
        }
        return content;
    }

    /**
     * 方法描述：封装需要替换的参数
     * 创建时间：2019-06-19 14:32:48
     * 创建作者：刘万琼
     *
     * @return the map
     */
    private static Map<String, Object> param(GeneratorParam param) {
        String pack = param.getPack();
        Map<String, Object> map = new HashMap<>();
        map.put("{{@servicePackagePath@}}", pack + ".service." + param.getFolderName());
        map.put("{{@controllerPackagePath@}}", pack + ".controller." + param.getFolderName());
        map.put("{{@mapperPath@}}", pack + ".mapper." + param.getFolderName() + "." + param.getClassName() + "Mapper");
        map.put("{{@pojoPath@}}", pack + ".pojo." + param.getFolderName() + "." + param.getClassName());
        map.put("{{@serviceTitle@}}", param.getServiceTitle());
        map.put("{{@controllerTitle@}}", param.getControllerTitle());
        map.put("{{@serviceName@}}", param.getClassName() + "Service");
        map.put("{{@serviceNameMin@}}", param.getAliasName() + "Service");
        map.put("{{@controllerName@}}", param.getClassName() + "Ctl");
        map.put("{{@mapperName@}}", param.getClassName() + "Mapper");
        map.put("{{@mapperNameMin@}}", param.getAliasName() + "Mapper");
        map.put("{{@date@}}", DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        map.put("{{@author@}}", param.getAuthor());
        map.put("{{@pojoName@}}", param.getClassName());
        map.put("{{@folderName@}}", param.getFolderName());
        map.put("{{@aliasName@}}", param.getAliasName());
        return map;
    }
}
