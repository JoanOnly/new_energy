package com.zxkj.energy.config.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Redis工具类
 *
 * @author 刘万琼
 */
@Component
public class RedisUtil {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 方法描述：普通缓存放入
     * 创建时间：2019-06-26 10:14:17
     * 创建作者：刘万琼
     *
     * @param key   the key 键
     * @param value the value 值
     * @return the boolean
     */
    public boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 方法描述：普通缓存获取
     * 创建时间：2019-06-26 10:16:43
     * 创建作者：刘万琼
     *
     * @param key the key
     * @return the object
     */
    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * 方法描述：指定缓存失效时间
     * 创建时间：2019-06-26 10:10:41
     * 创建作者：刘万琼
     *
     * @param key  the key
     * @param time the time 秒
     * @return the boolean
     */
    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 方法描述：普通缓存放入并设置时间
     * 创建时间：2019-06-26 10:18:14
     * 创建作者：刘万琼
     *
     * @param key   the key
     * @param value the value
     * @param time  the time
     * @return the boolean
     */
    public boolean set(String key, Object value, long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 方法描述：删除缓存
     * 创建时间：2019-06-26 11:28:18
     * 创建作者：刘万琼
     *
     * @param key the key
     */
    public void del(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 方法描述：hash set map 缓存放入
     * 创建时间：2019-06-26 14:25:52
     * 创建作者：刘万琼
     *
     * @param key the key
     * @param map the map
     * @return the boolean
     */
    public boolean hashSet(String key, Map<String, Object> map) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 方法描述：Hash get map 获取缓存
     *
     * @param key the key
     * @return the map
     */
    public Map<Object, Object> hashGet(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 判断key是否存在
     *
     * @param key 键
     * @return true 存在 false不存在
     */
    public boolean hasKey(String key) throws RuntimeException {
        return redisTemplate.hasKey(key);
    }
}
