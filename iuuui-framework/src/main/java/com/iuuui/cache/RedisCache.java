package com.iuuui.cache;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author iuuui
 * @since 2023/02/16 1739
 */
@Component
public class RedisCache {

    static RedisTemplate redis;

    public RedisCache(@Qualifier("redisTemplate") RedisTemplate redis) {
        this.redis = redis;
    }

    /**
     * 保存 hash
     * @param key
     * @param hashKey
     * @param value
     */
    public static void putForHash(String key, Object hashKey, Object value){
        redis.opsForHash().put(key, hashKey, value);
    }

    /**
     * 获取值 hash
     * @param key
     * @param hashKey
     * @return
     */
    public static Object getFromHash(String key, Object hashKey){
        return redis.opsForHash().get(key, hashKey);
    }

    /**
     * 删除 hash
     * @param key
     * @param hashKey
     */
    public static void delFromHash(String key, Object hashKey){
        redis.opsForHash().delete(key, hashKey);
    }

    /**
     * 获取 val
     * @param key
     * @return
     */
    public static Object getFromValue(String key){
        return redis.opsForValue().get(key);
    }

    /**
     * 保存 val
     * @param key
     * @param value
     */
    public static void setForValue(String key, Object value){
        redis.opsForValue().set(key, value);
    }

    public static void setExpireKeyForValue(String key, Object value, long timeout, TimeUnit unit){
        redis.opsForValue().set(key, value);
        redis.expire(key, timeout, unit);
    }

    public static void setExpireKey(String key, long timeout, TimeUnit unit){
        redis.expire(key, timeout, unit);
    }

    /**
     * 删除 key
     * @param key
     */
    public static void delFromValue(String key){
        redis.delete(key);
    }

    /**
     *  设置 key 存活时间
     * @param key
     * @param timeout
     * @param unit
     */
    public static void expireKey(String key, long timeout, TimeUnit unit){
        redis.expire(key,timeout,unit);
    }

    /**
     * 保存 val
     * @param key
     * @param value
     */
    public static void addForSet(String key, Object value){
        redis.opsForSet().add(key,value);
    }

    /**
     * 删除 val
     * @param key
     * @param value
     */
    public static void removeForSet(String key, Object value){
        redis.opsForSet().remove(key,value);
    }

    /**
     * 返回set里面所有对象
     * * @param key
     *
     */
    public static Set<Object> membersForSet(String key){
        return redis.opsForSet().members(key);
    }

}
