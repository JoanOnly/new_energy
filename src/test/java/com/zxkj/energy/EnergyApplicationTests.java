package com.zxkj.energy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EnergyApplicationTests {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void contextLoads() {
        System.out.println("111111");
    }

    @Test
    public void redisSet() {
        Map<String, String> map = new HashMap<>();
        map.put("v", "1");
        map.put("vq", "2");
        map.put("vw", "3");
        try {
            redisTemplate.opsForHash().putAll("energys", map);
//            redisTemplate.expire("energys", 60, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println(redisTemplate.opsForValue().get("energys"));
    }

    @Test
    public void redisGet() {
//        System.out.println(redisTemplate.opsForHash().get("energys","vw"));
        System.out.println(redisTemplate.hasKey("new_energy"));
    }

    @Test
    public void redisDel() {
        System.out.println(redisTemplate.delete("new_energy"));
    }

}
