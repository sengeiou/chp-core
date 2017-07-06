package com.creditharmony.core.security.shiro.cache;

import java.util.Collection;
import java.util.Set;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.util.SerializationUtils;

import redis.clients.jedis.JedisCluster;

import com.creditharmony.common.util.SerializeUtil;

/**
 * jedis的shiro缓存
 * @Class Name JedisShiroCache
 * @author 张永生
 * @Create In 2016年1月14日
 * @param <K>
 * @param <V>
 */
public class JedisShiroCache<K, V> implements Cache<K, V> {

    private static final String REDIS_SHIRO_CACHE = "shiro-cache:";

    private JedisCluster jedisCluster;

    private String name;

    public JedisShiroCache(String name, JedisCluster jedisCluster) {
        this.name = name;
        this.jedisCluster = jedisCluster;
    }

    /**
     * 自定义relm中的授权/认证的类名加上授权/认证英文名字
     */
    public String getName() {
        if (name == null)
            return "";
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @SuppressWarnings("unchecked")
    @Override
    public V get(K key) throws CacheException {
        byte[] byteKey = SerializationUtils.serialize(buildCacheKey(key));
        byte[] byteValue = new byte[0];
        try {
            byteValue = jedisCluster.get(byteKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (V) SerializationUtils.deserialize(byteValue);
    }

    @Override
    public V put(K key, V value) throws CacheException {
        V previos = get(key);
        try {
        	jedisCluster.set(SerializeUtil.serialize(buildCacheKey(key)),
                    SerializeUtil.serialize(value));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return previos;
    }

    @Override
    public V remove(K key) throws CacheException {
        V previos = get(key);
        try {
        	jedisCluster.del(SerializeUtil.serialize(buildCacheKey(key)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return previos;
    }

    @Override
    public void clear() throws CacheException {
        //TODO
    }

    @Override
    public int size() {
        if (keys() == null){
            return 0;
        }
        return keys().size();
    }

    @Override
    public Set<K> keys() {
        //TODO
        return null;
    }

    @Override
    public Collection<V> values() {
        //TODO
        return null;
    }

    private String buildCacheKey(Object key) {
        return REDIS_SHIRO_CACHE + getName() + ":" + key;
    }

}
