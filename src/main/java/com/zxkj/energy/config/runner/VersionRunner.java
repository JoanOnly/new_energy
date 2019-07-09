package com.zxkj.energy.config.runner;

import com.zxkj.energy.config.redis.RedisUtil;
import com.zxkj.energy.system.application.ApplicationUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目启动提示以及设置版本信息
 *
 * @author 刘万琼
 */

@Slf4j
@Component
@Order(value = 10)
public class VersionRunner implements CommandLineRunner {

    private final RedisUtil redisUtil;

    private final static String NEW_ENERGY_SYS = "new_energy_sys";

    public VersionRunner(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    @Override
    public void run(String... args) throws Exception {
        Integer vLevel = 2;
        if (args.length > 0) {
            vLevel = Integer.valueOf(args[0]);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("version", generateVersion(vLevel));
        map.put("name", ApplicationUtil.getInstance().getProperty("custom.webName"));
        map.put("description", ApplicationUtil.getInstance().getProperty("custom.webDescription"));
        redisUtil.hashSet(NEW_ENERGY_SYS, map);
        log.info(">>>> 项目启动成功！<<<<");
    }

    /**
     * 生成版本号，基于redis的，默认v0.0.1
     * 参数传入要求：
     * 重大更新：0
     * 功能增删：1
     * 小bug修改：2
     *
     * @param vLevel 启动项目的级别【0,1,2】
     * @return 返回版本号
     */
    private String generateVersion(Integer vLevel) {
        String version = "v0.0.1";
        if (redisUtil.hasKey(NEW_ENERGY_SYS)) {
            Map<Object, Object> map = redisUtil.hashGet(NEW_ENERGY_SYS);
            version = String.valueOf(map.get("version"));
            if (!version.isEmpty()) {
                String[] versions = version.substring(1, version.length()).split("\\.");
                versions[vLevel] = String.valueOf(Integer.parseInt(versions[vLevel].trim()) + 1);
                version = "v" + String.join(".", versions);
            }
        }
        log.info(">>>> 新能源系统版本号：{} <<<<", version);
        return version;
    }
}
