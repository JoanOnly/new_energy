package com.zxkj.energy.generator;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.codegen.mybatis3.javamapper.elements.AbstractJavaMapperMethodGenerator;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.TreeSet;

/**
 * 方法描述：在mapper添加自定义接口
 * 创建时间：2019-04-18
 * 创建作者：刘万琼
 */
public class CustomMapper extends AbstractJavaMapperMethodGenerator {

    @Override
    public void addInterfaceElements(Interface face) {
        addAnnotation(face);
        addInterfaceFind(face);
        addInterfaceList(face);
        addInterfaceDeleteById(face);
        addInsertBatch(face);
        addUpdateBatch(face);
    }

    /**
     * 方法描述：在mapper添加注解
     * 创建时间：2019-04-18
     * 创建作者：刘万琼
     */
    private void addAnnotation(Interface face) {
        FullyQualifiedJavaType mapper, component,param;
        param = new FullyQualifiedJavaType(Param.class.getName());
        mapper = new FullyQualifiedJavaType(Mapper.class.getName());
        component = new FullyQualifiedJavaType(Component.class.getName());
        face.addImportedType(param);
        face.addImportedType(mapper);
        face.addImportedType(component);
        face.addAnnotation("@Mapper");
        face.addAnnotation("@Component");
    }

    /**
     * 方法描述：添加find接口
     * 创建时间：2019-04-18
     * 创建作者：刘万琼
     */
    private void addInterfaceFind(Interface face) {
        // 先创建import对象
        Set<FullyQualifiedJavaType> importedTypes = new TreeSet<>();
        // 添加Lsit的包
        importedTypes.add(FullyQualifiedJavaType.getNewListInstance());
        // 创建方法对象
        Method method = new Method();
        // 设置该方法为public
        method.setVisibility(JavaVisibility.PUBLIC);
        // 设置返回类型是对象
        FullyQualifiedJavaType returnType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
        // 方法对象设置返回类型对象
        method.setReturnType(returnType);
        // 设置方法名称为我们在IntrospectedTable类中初始化的 “selectByObject”
        method.setName("find");

        // 设置参数类型是对象
        FullyQualifiedJavaType parameterType;
        parameterType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
        // import参数类型对象
        importedTypes.add(parameterType);
        // 为方法添加参数，变量名称record
        method.addParameter(new Parameter(parameterType, "record"));
        context.getCommentGenerator().addGeneralMethodComment(method, introspectedTable);
        if (context.getPlugins().clientSelectByPrimaryKeyMethodGenerated(method, face, introspectedTable)) {
            face.addImportedTypes(importedTypes);
            face.addMethod(method);
        }
    }

    /**
     * 方法描述：添加list接口
     * 创建时间：2019-04-18
     * 创建作者：刘万琼
     */
    private void addInterfaceList(Interface face) {
        // 先创建import对象
        Set<FullyQualifiedJavaType> importedTypes = new TreeSet<>();
        // 添加Lsit的包
        importedTypes.add(FullyQualifiedJavaType.getNewListInstance());
        // 创建方法对象
        Method method = new Method();
        // 设置该方法为public
        method.setVisibility(JavaVisibility.PUBLIC);
        // 设置返回类型是List
        FullyQualifiedJavaType returnType = FullyQualifiedJavaType.getNewListInstance();
        FullyQualifiedJavaType listType;
        // 设置List的类型是实体类的对象
        listType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
        importedTypes.add(listType);
        // 返回类型对象设置为List
        returnType.addTypeArgument(listType);
        // 方法对象设置返回类型对象
        method.setReturnType(returnType);
        // 设置方法名称为我们在IntrospectedTable类中初始化的 “selectByObject”
        method.setName("list");

        // 设置参数类型是对象
        FullyQualifiedJavaType parameterType;
        parameterType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
        // import参数类型对象
        importedTypes.add(parameterType);
        // 为方法添加参数，变量名称record
        method.addParameter(new Parameter(parameterType, "record")); //$NON-NLS-1$
        context.getCommentGenerator().addGeneralMethodComment(method, introspectedTable);
        if (context.getPlugins().clientSelectByPrimaryKeyMethodGenerated(method, face, introspectedTable)) {
            face.addImportedTypes(importedTypes);
            face.addMethod(method);
        }
    }

    /**
     * 方法描述：添加逻辑删除接口
     * 创建时间：2019-04-18
     * 创建作者：刘万琼
     */
    private void addInterfaceDeleteById(Interface face) {
        // 先创建import对象
        Set<FullyQualifiedJavaType> importedTypes = new TreeSet<>();
        // 创建方法对象
        Method method = new Method();
        // 设置该方法为public
        method.setVisibility(JavaVisibility.PUBLIC);
        // 设置返回类型是对象
        FullyQualifiedJavaType returnType = new FullyQualifiedJavaType("int");
        // 方法对象设置返回类型对象
        method.setReturnType(returnType);
        // 设置方法名称为我们在IntrospectedTable类中初始化的 “selectByObject”
        method.setName("deleteById");

        // 设置参数类型是对象 这个对象是主键的类型
        FullyQualifiedJavaType parameterType;
        parameterType = new FullyQualifiedJavaType("Long");
        // import参数类型对象
        importedTypes.add(parameterType);
        // 为方法添加参数，变量名称record
        method.addParameter(new Parameter(parameterType, "id"));
        context.getCommentGenerator().addGeneralMethodComment(method, introspectedTable);
        if (context.getPlugins().clientSelectByPrimaryKeyMethodGenerated(method, face, introspectedTable)) {
            face.addImportedTypes(importedTypes);
            face.addMethod(method);
        }
    }

    /**
     * 方法描述：添加批量插入接口
     * 创建时间：2019-04-18
     * 创建作者：刘万琼
     */
    private void addInsertBatch(Interface face) {
        // 先创建import对象
        Set<FullyQualifiedJavaType> importedTypes = new TreeSet<>();
        // 创建方法对象
        Method method = new Method();
        // 设置该方法为public
        method.setVisibility(JavaVisibility.PUBLIC);
        // 设置返回类型是对象
        FullyQualifiedJavaType returnType = new FullyQualifiedJavaType("int");
        // 方法对象设置返回类型对象
        method.setReturnType(returnType);
        // 设置方法名称为我们在IntrospectedTable类中初始化的 “selectByObject”
        method.setName("insertBatch");

        // 设置参数类型是对象 这个对象是主键的类型
        FullyQualifiedJavaType parameterType;
        parameterType = new FullyQualifiedJavaType("@Param(\"insertList\") List<" + introspectedTable.getBaseRecordType() + ">");
        // import参数类型对象
        importedTypes.add(parameterType);
        // 为方法添加参数，变量名称record
        method.addParameter(new Parameter(parameterType, "insertList"));
        context.getCommentGenerator().addGeneralMethodComment(method, introspectedTable);
        if (context.getPlugins().clientSelectByPrimaryKeyMethodGenerated(method, face, introspectedTable)) {
            face.addImportedTypes(importedTypes);
            face.addMethod(method);
        }
    }

    /**
     * 方法描述：添加批量修改接口
     * 创建时间：2019-04-18
     * 创建作者：刘万琼
     */
    private void addUpdateBatch(Interface face) {
        // 先创建import对象
        Set<FullyQualifiedJavaType> importedTypes = new TreeSet<>();
        // 创建方法对象
        Method method = new Method();
        // 设置该方法为public
        method.setVisibility(JavaVisibility.PUBLIC);
        // 设置返回类型是对象
        FullyQualifiedJavaType returnType = new FullyQualifiedJavaType("int");
        // 方法对象设置返回类型对象
        method.setReturnType(returnType);
        // 设置方法名称为我们在IntrospectedTable类中初始化的 “selectByObject”
        method.setName("updateBatch");

        // 设置参数类型是对象 这个对象是主键的类型
        FullyQualifiedJavaType parameterType;
        parameterType = new FullyQualifiedJavaType("@Param(\"updateList\") List<" + introspectedTable.getBaseRecordType() + ">");
        // import参数类型对象
        importedTypes.add(parameterType);
        // 为方法添加参数，变量名称record
        method.addParameter(new Parameter(parameterType, "updateList"));
        context.getCommentGenerator().addGeneralMethodComment(method, introspectedTable);
        if (context.getPlugins().clientSelectByPrimaryKeyMethodGenerated(method, face, introspectedTable)) {
            face.addImportedTypes(importedTypes);
            face.addMethod(method);
        }
    }
}
