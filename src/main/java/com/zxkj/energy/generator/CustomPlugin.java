package com.zxkj.energy.generator;

import lombok.Data;
import org.mybatis.generator.api.*;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.codegen.mybatis3.javamapper.elements.AbstractJavaMapperMethodGenerator;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.AbstractXmlElementGenerator;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Properties;

/**
 * 方法描述：自定义生成插件
 * 创建作者：刘万琼
 */
public class CustomPlugin extends PluginAdapter {
    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    /**
     * 方法描述：重写XML
     * 创建时间：2019-04-18
     * 创建作者：刘万琼
     *
     * @param document          the document
     * @param introspectedTable the introspectedTable
     */
    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
        AbstractXmlElementGenerator elementGenerator = new CustomXmlSql();
        elementGenerator.setContext(context);
        elementGenerator.setIntrospectedTable(introspectedTable);
        elementGenerator.addElements(document.getRootElement());
        return super.sqlMapDocumentGenerated(document, introspectedTable);
    }

    /**
     * 方法描述：重写mapper
     * 创建时间：2019-04-18
     * 创建作者：刘万琼
     *
     * @param face          the face
     * @param topLevelClass the topLevelClass
     */
    @Override
    public boolean clientGenerated(Interface face, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        AbstractJavaMapperMethodGenerator methodGenerator = new CustomMapper();
        methodGenerator.setContext(context);
        methodGenerator.setIntrospectedTable(introspectedTable);
        methodGenerator.addInterfaceElements(face);
        return super.clientGenerated(face, topLevelClass, introspectedTable);
    }

    /**
     * 方法描述：在pojo加@Data注解
     * 创建时间：2019-06-18
     * 创建作者：刘万琼
     */
    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        FullyQualifiedJavaType param = new FullyQualifiedJavaType(Data.class.getName());
        topLevelClass.addImportedType(param);
        topLevelClass.addAnnotation("@Data");
        return super.modelBaseRecordClassGenerated(topLevelClass, introspectedTable);
    }

    /**
     * 方法描述：不生成Getter方法
     * 创建时间：2019-06-18
     * 创建作者：刘万琼
     */
    @Override
    public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        return false;
    }

    /**
     * 方法描述：不生成Setter方法
     * 创建时间：2019-06-18
     * 创建作者：刘万琼
     */
    @Override
    public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        return false;
    }

    /**
     * mapper文件可被重写的插件，默认情况下，重新生成代码时，mapper下的xml文件不会被覆盖
     * 通过参数mapperOverwrite决定是否覆盖xml文件，该值默认为true
     */
    private boolean mapperOverwrite = true;

    /**
     * 方法描述：将mapperOverwrite设置问true
     * 创建时间：2019-04-18
     * 创建作者：刘万琼
     *
     * @param properties the properties
     */
    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
        mapperOverwrite = Boolean.valueOf(properties.getProperty("mapperOverwrite", String.valueOf(mapperOverwrite)));
    }

    /**
     * 方法描述：覆盖xml
     * 创建时间：2019-04-18
     * 创建作者：刘万琼
     *
     * @param sqlMap            the sqlMap
     * @param introspectedTable the introspectedTable
     */
    @Override
    public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
        if (mapperOverwrite) {
            try {
                Field mergedField = GeneratedXmlFile.class.getDeclaredField("isMergeable");
                mergedField.setAccessible(true);
                mergedField.setBoolean(sqlMap, false);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return super.sqlMapGenerated(sqlMap, introspectedTable);
    }
}
