package com.zxkj.energy.generator;

import lombok.Data;

/**
 * 方法描述：格式化信息
 * 创建时间：2019-06-18
 * 创建作者：刘万琼
 */
@Data
class GeneratorParam {

    private String jdbcUrl;

    private String jdbcUser;

    private String jdbcPsd;

    private String jdbcDriver;

    private String classPath;

    private String tableName;

    private String className;

    private String aliasName;

    private String folderName;

    private String author;

    private String serviceTitle;

    private String controllerTitle;

    private String packageUrl;

    private String pack;

    private String directory;

}
