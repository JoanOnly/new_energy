package com.zxkj.energy.generator;

import org.mybatis.generator.config.*;
import org.springframework.stereotype.Component;

@Component
public class GeneratorConfig {

    public static Configuration config(GeneratorParam param) {
        // 封装配置文件中的context
        Context context = new Context(null);
        context.setId("DB2Tables");
        context.setTargetRuntime("MyBatis3");
        context = plugins(context);
        context.setCommentGeneratorConfiguration(commentGenerator(new CommentGeneratorConfiguration()));
        context.setJdbcConnectionConfiguration(jdbc(new JDBCConnectionConfiguration(), param));
        context.setJavaTypeResolverConfiguration(resolver(new JavaTypeResolverConfiguration()));
        context.setJavaModelGeneratorConfiguration(model(param.getFolderName(), param.getPack()));
        context.setSqlMapGeneratorConfiguration(sqlMap(param.getFolderName()));
        context.setJavaClientGeneratorConfiguration(javaClient(param.getFolderName(), param.getPack()));
        context.addTableConfiguration(table(context, param));

        // 封装Configuration配置文件
        Configuration config = new Configuration();
        config.addClasspathEntry(param.getClassPath());
        config.addContext(context);
        return config;
    }

    /**
     * 方法描述：格式化信息 如果市引入多个插件，则实例化多个PluginConfiguration，然后一个一个的分别加入到context
     * 创建时间：2019-06-18 15:29:05
     * 创建作者：刘万琼
     */
    private static Context plugins(Context context) {
        // 生成的pojo，将实现Serializable
        PluginConfiguration plugin = new PluginConfiguration();
        plugin.setConfigurationType("org.mybatis.generator.plugins.SerializablePlugin");
        context.addPluginConfiguration(plugin);

        // 生成的pojo自带toString方法
        // PluginConfiguration plugin1 = new PluginConfiguration();
        // plugin1.setConfigurationType("org.mybatis.generator.plugins.ToStringPlugin");
        // context.addPluginConfiguration(plugin1);

        // 自定义配置文件
        PluginConfiguration plugin2 = new PluginConfiguration();
        plugin2.setConfigurationType("com.zxkj.energy.generator.CustomPlugin");
        context.addPluginConfiguration(plugin2);
        return context;
    }

    /**
     * 方法描述：设置是否生成注释
     * 创建时间：2019-06-18
     * 创建作者：刘万琼
     */
    private static CommentGeneratorConfiguration commentGenerator(CommentGeneratorConfiguration comment) {
        comment.addProperty("suppressDate", "true");
        //是否去除自动生成的注释
        comment.addProperty("suppressAllComments", "true");
        return comment;
    }

    /**
     * 方法描述：设置数据库信息
     * 创建时间：2019-06-18
     * 创建作者：刘万琼
     */
    private static JDBCConnectionConfiguration jdbc(JDBCConnectionConfiguration jdbc, GeneratorParam param) {
        jdbc.setDriverClass(param.getJdbcDriver());
        jdbc.setConnectionURL(param.getJdbcUrl());
        jdbc.setUserId(param.getJdbcUser());
        jdbc.setPassword(param.getJdbcPsd());
        return jdbc;
    }

    /**
     * 方法描述：java类型解析器配置
     * 创建时间：2019-06-18
     * 创建作者：刘万琼
     */
    private static JavaTypeResolverConfiguration resolver(JavaTypeResolverConfiguration resolver) {
        //是否使用bigDecimal， false可自动转化以下类型（Long, Integer, Short, etc.）
        resolver.addProperty("forceBigDecimals", "false");
        return resolver;
    }

    /**
     * 方法描述：生成pojo实体类地址
     * 创建时间：2019-06-18
     * 创建作者：刘万琼
     */
    private static JavaModelGeneratorConfiguration model(String folderName, String pack) {
        JavaModelGeneratorConfiguration model = new JavaModelGeneratorConfiguration();
        model.setTargetPackage(pack + ".pojo." + folderName);
        model.setTargetProject("src/main/java");
        model.addProperty("enableSubPackages", "true");
        model.addProperty("trimStrings", "true");
        return model;
    }

    /**
     * 方法描述：生成XML映射文件的地址
     * 创建时间：2019-06-18
     * 创建作者：刘万琼
     */
    private static SqlMapGeneratorConfiguration sqlMap(String folderName) {
        SqlMapGeneratorConfiguration sqlMap = new SqlMapGeneratorConfiguration();
        sqlMap.setTargetPackage("mybatis.mapper." + folderName);
        sqlMap.setTargetProject("src/main/resources");
        sqlMap.addProperty("enableSubPackages", "true");
        return sqlMap;
    }

    /**
     * 方法描述：生成DAO（mapper）的地址
     * 创建时间：2019-06-18
     * 创建作者：刘万琼
     */
    private static JavaClientGeneratorConfiguration javaClient(String folderName, String pack) {
        JavaClientGeneratorConfiguration javaClient = new JavaClientGeneratorConfiguration();
        javaClient.setTargetPackage(pack + ".mapper." + folderName);
        javaClient.setTargetProject("src/main/java");
        javaClient.setConfigurationType("XMLMAPPER");
        javaClient.addProperty("enableSubPackages", "true");
        return javaClient;
    }

    /**
     * 方法描述：生成数据库中的表名或视图名 domainObjectName是实体类名
     * 创建时间：2019-06-18
     * 创建作者：刘万琼
     */
    private static TableConfiguration table(Context context, GeneratorParam param) {
        TableConfiguration table = new TableConfiguration(context);
        table.setTableName(param.getTableName());
        table.setDomainObjectName(param.getClassName());
        table.setCountByExampleStatementEnabled(false);
        table.setUpdateByExampleStatementEnabled(false);
        table.setDeleteByExampleStatementEnabled(false);
        table.setSelectByExampleStatementEnabled(false);
        table.setDeleteByPrimaryKeyStatementEnabled(false);
        return table;
    }
}
