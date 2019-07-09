package com.zxkj.energy;

import com.zxkj.energy.system.application.Custom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JoanTest {
    @Autowired
    private Custom custom;

    /**
     * 方法描述：测试读取application中的custom自定义配置
     * 通过CustomApplication基类读取
     * 创建时间：2019-07-01 16:00:18
     * 创建作者：刘万琼
     */
    @Test
    public void application() {
        System.out.println("webName: " + custom.getWebName());
        System.out.println("webDescription: " + custom.getWebDescription());
        System.out.println("attachmentServer: " + custom.getAttachmentGainPath());
        System.out.println("attachmentPath: " + custom.getAttachmentPath());
        System.out.println("attachmentGainPath: " + custom.getAttachmentServer());
        System.out.println("attachmentTempPath: " + custom.getAttachmentTempPath());
    }
}
