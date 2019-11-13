package com.linxd.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created with IntelliJ IDEA.
 *
 * @author linxd
 * @date 2019/11/6 12:10
 * Description: No Description
 */
@Slf4j
@Component
public class RedisUtil {
    @Autowired
    private JedisPool jedisPool;

    /**
     *
     * @param key
     * @return 成功返回value 失败返回null
     */
    public String get(String key) {
        Jedis jedis = null;
        String value = null;
        try {
            jedis = jedisPool.getResource();
            value = jedis.get(key);
            log.info("value====================================>" + value);

        } catch (Exception e) {
            log.error(e.toString() + e.getMessage());
        } finally {
            close(jedisPool, jedis);
        }

        return value;
    }

    /**
     *
     * @param key
     * @param value
     * @return 返回OK 失败返回NO
     */
    public String set(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.set(key, value);
        } catch (Exception e) {
            log.error(e.toString() + e.getMessage());
            return "NO";
        } finally {
            close(jedisPool, jedis);
        }

    }

    /**
     *
     * @param keys
     * @return 返回删除成功的个数
     */
    public Long del(String... keys) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.del(keys);
        } catch (Exception e) {
            log.error(e.toString() + e.getMessage());
            return 0L;
        } finally {
            close(jedisPool, jedis);
        }

    }

    /**
     *
     * @param key
     * @param str
     * @return 成功返回 添加后value的长度
     *         失败返回 添加的value的长度 异常返回0L
     */
    public Long append(String key, String str) {
        Jedis jedis = null;
        Long result = null;
        try {
            jedis = jedisPool.getResource();
            result = jedis.append(key, str);
        } catch (Exception e) {
            log.error(e.toString() + e.getMessage());
            return 0L;
        } finally {
            close(jedisPool, jedis);
        }
        return result;
    }

    /**
     *
     * @param key
     * @return true OR false
     */
    public Boolean exists(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.exists(key);
        } catch (Exception e) {
            log.error(e.toString() + e.getMessage());
            return false;
        } finally {
            close(jedisPool, jedis);
        }
    }


    public static void close(JedisPool jedisPool, Jedis jedis) {
        if (jedis != null) {
            jedisPool.returnResource(jedis);
        }
    }


}
