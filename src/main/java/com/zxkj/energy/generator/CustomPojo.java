package com.zxkj.energy.generator;

import lombok.Data;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;

/**
 * @author 刘万琼
 *
 * 生成pojo的注解
 */
public class CustomPojo extends PluginAdapter {

    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    @Override
    public boolean modelRecordWithBLOBsClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        FullyQualifiedJavaType param;
        param = new FullyQualifiedJavaType(Data.class.getName());
        topLevelClass.addImportedType(param);
        topLevelClass.addAnnotation("@Data");
        return super.modelRecordWithBLOBsClassGenerated(topLevelClass, introspectedTable);
    }
}
