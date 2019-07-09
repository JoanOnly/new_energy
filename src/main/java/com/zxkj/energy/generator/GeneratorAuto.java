package com.zxkj.energy.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述：代码生成器主函数入口
 * 作者：刘万琼
 */
public class GeneratorAuto {

    private static GeneratorParam param(GeneratorParam param) {
        // 需要生成的数据库表名
        param.setTableName("company_info");
        // 生成的实体类名（类名首字母大写）
        param.setClassName("CompanyInfo");
        // 生成引用类的别名
        param.setAliasName("companyInfo");
        // 生成模块的文件名
        param.setFolderName("user");
        // 生成接口操作人
        param.setAuthor("刘万琼");
        // 业务逻辑层说明
        param.setServiceTitle("公司");
        // 控制层说明
        param.setControllerTitle("公司");
        // mysql驱动的路径
        param.setClassPath("C:/Users/kmzx/Projects/new_energy/sdk/mysql-connector-java-5.1.30.jar");
        // JDBC驱动程序类
        param.setJdbcDriver("com.mysql.jdbc.Driver");
        // 数据库连接的地址
        param.setJdbcUrl("jdbc:mysql://localhost:3306/new_energy");
        // 数据库连接的用户名
        param.setJdbcUser("root");
        // 数据库连接的密码
        param.setJdbcPsd("123456");
        // 包名路径
        param.setPackageUrl("com\\zxkj\\energy");
        // 包名
        param.setPack("com.zxkj.energy");
        // 生成项目主目录
        param.setDirectory("C:\\Users\\kmzx\\Projects\\new_energy");

        return param;
    }

    public static void main(String[] args) throws InvalidConfigurationException, InterruptedException, SQLException, IOException {
        List<String> warnings = new ArrayList<>();
        boolean overwrite = true;
        GeneratorParam param = param(new GeneratorParam());
        Configuration config = GeneratorConfig.config(param);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);

        // 生成service和controller
        CustomCode.copyService(param);
        CustomCode.copyController(param);
    }
}
