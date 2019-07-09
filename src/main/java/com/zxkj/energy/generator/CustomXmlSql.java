package com.zxkj.energy.generator;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.AbstractXmlElementGenerator;

import java.util.List;

/**
 * 方法描述：生成mapping 在xml添加自定义sql
 * 创建时间：2019-04-18
 * 创建作者：刘万琼
 */
public class CustomXmlSql extends AbstractXmlElementGenerator {

    /**
     * 方法描述：在xml添加自定义sql
     * 创建时间：2019-04-18
     * 创建作者：刘万琼
     */
    @Override
    public void addElements(XmlElement xmlElement) {
        //获取表名
        String tableName = introspectedTable.getFullyQualifiedTableNameAtRuntime();
        //获取所有列
        List<IntrospectedColumn> columns = introspectedTable.getAllColumns();
        // 增加sql_where
        XmlElement sql = new XmlElement("sql");
        sql.addAttribute(new Attribute("id", "sql_where"));
        // 添加where条件
        XmlElement where = new XmlElement("where");
        StringBuilder sb = new StringBuilder();
        for (IntrospectedColumn introspectedColumn : introspectedTable.getNonPrimaryKeyColumns()) {
            XmlElement isNotNullElement = new XmlElement("if");
            sb.setLength(0);
            sb.append(introspectedColumn.getJavaProperty());
            sb.append(" != null");
            isNotNullElement.addAttribute(new Attribute("test", sb.toString()));
            where.addElement(isNotNullElement);

            sb.setLength(0);
            sb.append(" and ");
            sb.append(MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn));
            sb.append(" = ");
            sb.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn));
            isNotNullElement.addElement(new TextElement(sb.toString()));
        }
        sql.addElement(where);
        xmlElement.addElement(sql);

        // 公用select
        sb.setLength(0);
        sb.append("select ");
        sb.append("* ");
        sb.append("from ");
        sb.append(tableName);
        TextElement select = new TextElement(sb.toString());

        // 公用的include
        XmlElement include = new XmlElement("include");
        include.addAttribute(new Attribute("refid", "sql_where"));

        //添加list
        XmlElement list = new XmlElement("select");
        list.addAttribute(new Attribute("id", "list"));
        list.addAttribute(new Attribute("resultMap", "BaseResultMap"));
        list.addAttribute(new Attribute("parameterType", introspectedTable.getBaseRecordType()));
        list.addElement(select);
        list.addElement(include);
        xmlElement.addElement(list);

        //添加find
        XmlElement find = new XmlElement("select");
        find.addAttribute(new Attribute("id", "find"));
        find.addAttribute(new Attribute("resultMap", "BaseResultMap"));
        find.addAttribute(new Attribute("parameterType", introspectedTable.getBaseRecordType()));
        find.addElement(select);
        find.addElement(include);
        xmlElement.addElement(find);

        //添加deleteById的sql
        deleteById(xmlElement, tableName);

        //添加批量插入的sql
        insertBatch(xmlElement, tableName);

        //添加批量修改的sql
        updateBatch(xmlElement, tableName);


    }

    /**
     * 方法描述：添加deleteById自定义sql
     * 创建时间：2019-04-19
     * 创建作者：刘万琼
     */
    private void deleteById(XmlElement xmlElement, String tableName) {
        //添加deleteById
        XmlElement deleteById = new XmlElement("update");
        deleteById.addAttribute(new Attribute("id", "deleteById"));
        deleteById.addAttribute(new Attribute("parameterType", "java.lang.Long"));
        //获取单个属性
        final IntrospectedColumn column = introspectedTable.getColumn("id");
        //获取某个属性的参数
        final String param = MyBatis3FormattingUtilities.getParameterClause(column);
        deleteById.addElement(new TextElement(" update " + tableName + " set is_delete = true where id = " + param));
        xmlElement.addElement(deleteById);
    }

    /**
     * 方法描述：添加批量插入自定义sql
     * 创建时间：2019-04-19
     * 创建作者：刘万琼
     */
    private void insertBatch(XmlElement xmlElement, String tableName) {
        //获取所有字段
        XmlElement baseColumnList = new XmlElement("include");
        baseColumnList.addAttribute(new Attribute("refid", "Base_Column_List"));

        //填充foreach中的属性
        StringBuilder attribute = new StringBuilder();
        for (IntrospectedColumn introspectedColumn : introspectedTable.getAllColumns()) {
            attribute.append("#{item.");
            attribute.append(introspectedColumn.getJavaProperty());
            attribute.append("},");
        }

        //去掉foreach内容中的最后一个逗号
        String attr = attribute.toString().substring(0, attribute.length() - 1);

        //foreach
        XmlElement foreach = new XmlElement("foreach");
        foreach.addAttribute(new Attribute("collection", "insertList"));
        foreach.addAttribute(new Attribute("item", "item"));
        foreach.addAttribute(new Attribute("index", "index"));
        foreach.addAttribute(new Attribute("separator", ","));
        foreach.addElement(new TextElement("("));
        foreach.addElement(new TextElement(attr));
        foreach.addElement(new TextElement(")"));

        //添加批量插入的方法
        XmlElement insertBatch = new XmlElement("insert");
        insertBatch.addAttribute(new Attribute("id", "insertBatch"));
        insertBatch.addAttribute(new Attribute("parameterType", "java.util.List"));
        insertBatch.addElement(new TextElement(" insert into " + tableName + " ( "));
        insertBatch.addElement(baseColumnList);
        insertBatch.addElement(new TextElement(" ) VALUES "));
        insertBatch.addElement(foreach);
        xmlElement.addElement(insertBatch);
    }

    /**
     * 方法描述：添加批量修改自定义sql
     * 创建时间：2019-04-19
     * 创建作者：刘万琼
     */
    private void updateBatch(XmlElement xmlElement, String tableName) {
        //填充set中的属性
        StringBuilder setAttr = new StringBuilder();
        for (IntrospectedColumn introspectedColumn : introspectedTable.getNonPrimaryKeyColumns()) {
            setAttr.append(MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn));
            setAttr.append(" = ");
            setAttr.append("#{item.");
            setAttr.append(introspectedColumn.getJavaProperty());
            setAttr.append("},");
        }

        //去掉set内容中的最后一个逗号
        String attr = setAttr.toString().substring(0, setAttr.length() - 1);

        //set
        XmlElement set = new XmlElement("set");
        set.addElement(new TextElement(attr));

        //foreach
        XmlElement foreach = new XmlElement("foreach");
        foreach.addAttribute(new Attribute("collection", "updateList"));
        foreach.addAttribute(new Attribute("item", "item"));
        foreach.addAttribute(new Attribute("index", "index"));
        foreach.addAttribute(new Attribute("open", ""));
        foreach.addAttribute(new Attribute("close", ""));
        foreach.addAttribute(new Attribute("separator", ";"));
        foreach.addElement(new TextElement(" update " + tableName));
        foreach.addElement(set);
        foreach.addElement(new TextElement("where id = " + "#{item.id}"));

        //添加批量修改的方法
        XmlElement updateBatch = new XmlElement("update");
        updateBatch.addAttribute(new Attribute("id", "updateBatch"));
        updateBatch.addAttribute(new Attribute("parameterType", "java.util.List"));
        updateBatch.addElement(foreach);
        xmlElement.addElement(updateBatch);
    }

}
