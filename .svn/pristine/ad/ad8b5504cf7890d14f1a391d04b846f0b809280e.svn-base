package com.creditharmony.core.security.shiro.cache;

import org.apache.shiro.cache.Cache;

import redis.clients.jedis.JedisCluster;

/**
 * jedis实现的shiro缓存管理类
 * name是指自定义relm中的授权/认证的类名加上授权/认证英文名字
 * @Class Name JedisShiroCacheManager
 * @author 张永生
 * @Create In 2016年1月14日
 */
public class JedisShiroCacheManager implements ShiroCacheManager {

    private JedisCluster jedisCluster;

    @Override
    public <K, V> Cache<K, V> getCache(String name) {
        return new JedisShiroCache<K, V>(name, getJedisCluster());
    }

    @Override
    public void destroy() {
    	//TODO
    	//getJedisCluster().shutdown();
    }

	public JedisCluster getJedisCluster() {
		return jedisCluster;
	}

	public void setJedisCluster(JedisCluster jedisCluster) {
		this.jedisCluster = jedisCluster;
	}

   
}
