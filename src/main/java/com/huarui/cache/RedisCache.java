package com.huarui.cache;

import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RedisCache{

}

/*
public class RedisCache implements Cache {

    private String id;

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public RedisCache(String id) {
        this.id = id;
    }

    private RedisTemplate<Object, Object> getRedisTemplate(){
        return SpringContextHolder.getBean("redisTemplate");
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void putObject(Object key, Object value) {
        getRedisTemplate().boundHashOps(getId()).put(key, value);
    }

    @Override
    public Object getObject(Object key) {
        return getRedisTemplate().boundHashOps(getId()).get(key);
    }

    @Override
    public Object removeObject(Object key) {
        return getRedisTemplate().boundHashOps(getId()).delete(key);
    }

    @Override
    public void clear() {
        getRedisTemplate().delete(getId());
    }

    @Override
    public int getSize() {
        Long size = getRedisTemplate().boundHashOps(getId()).size();
        return size == null ? 0 : size.intValue();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }
}

*/