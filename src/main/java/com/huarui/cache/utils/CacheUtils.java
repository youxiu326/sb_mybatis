package com.huarui.cache.utils;

import com.huarui.cache.SpringContextHolder;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 缓存工具类
 */
public class CacheUtils {

    private static RedisTemplate<String, Object> redisTemplate = SpringContextHolder.getBean("redisTemplate");

    public static Object getCache(String key){
        return redisTemplate.opsForValue().get(key);
    }

    public static Object getCache(String key, int timer){
        Object value = redisTemplate.opsForValue().get(key);
        setCache( key, value,  timer) ;
        return value;
    }

    public static void setCache(String key, Object value, int timer) {
        redisTemplate.opsForValue().set(key.toString(), value, timer, TimeUnit.DAYS);
    }

    public static void setCache(String key, Object value) {
       redisTemplate.opsForValue().set(key.toString(), value);
    }

    public static void delCacheByKey(String key){
        redisTemplate.delete(key);
    }

    public static boolean exists(String key){
        return redisTemplate.hasKey(key);
    }

    public static Set<Object> keys(String key){
        Set<Object> execute = redisTemplate.execute(new RedisCallback<Set<Object>>() {
            @Override
            public Set<Object> doInRedis(RedisConnection connection) throws DataAccessException {

                Set<Object> binaryKeys = new HashSet<>();

                Cursor<byte[]> cursor = connection.scan( new ScanOptions.ScanOptionsBuilder().match(key).count(1000).build());
                while (cursor.hasNext()) {
                    binaryKeys.add(new String(cursor.next()));
                }
                return binaryKeys;
            }
        });
        return execute;
    }

}
