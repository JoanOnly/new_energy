package com.zxkj.energy.system.application;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 加载application的custom自定义配置
 * 缺点：在static 接口中不能使用
 *
 * @author 刘万琼
 */
@Data
@ToString
@Component
@ConfigurationProperties(prefix = "custom")
public class Custom {
    private String webName;
    private String webDescription;
    private String attachmentServer;
    private String attachmentPath;
    private String attachmentGainPath;
    private String attachmentTempPath;
}
