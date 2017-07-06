package com.creditharmony.core.security.shiro.session;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.SerializationUtils;

import redis.clients.jedis.JedisCluster;


/**
 * redis保存sesssion的类
 * @Class Name JedisShiroSessionRepository
 * @author 张永生
 * @Create In 2016年1月14日
 */
public class JedisShiroSessionRepository implements ShiroSessionRepository {

    private static final String REDIS_SHIRO_SESSION = "shiro-session:";
    private static final int SESSION_VAL_TIME_SPAN = 18000;
    
    private static final Logger logger = LoggerFactory.getLogger(JedisShiroSessionRepository.class);
    
    @Autowired
	private JedisCluster jedisCluster;

    @Override
    public void saveSession(Session session) {
        if (session == null || session.getId() == null){
            throw new NullPointerException("session is empty");
        }
        try {
            byte[] key = SerializationUtils.serialize(buildRedisSessionKey(session.getId()));
            byte[] value = SerializationUtils.serialize(session);
            long sessionTimeOut = session.getTimeout() / 1000;
            Long expireTime = sessionTimeOut + SESSION_VAL_TIME_SPAN + (5 * 60)+7200;
            //logger.info("sessionTimeOut:{},expireTime:{},key:{}",sessionTimeOut,expireTime,String.valueOf(key));
            getJedisCluster().setex(key, expireTime.intValue(), value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSession(Serializable id) {
        if (id == null) {
            throw new NullPointerException("session id is empty");
        }
        try {
        	getJedisCluster().del(SerializationUtils.serialize(buildRedisSessionKey(id)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Session getSession(Serializable id) {
        if (id == null){
            throw new NullPointerException("session id is empty");
        }
        Session session = null;
        try {
            byte[] value = getJedisCluster().get(SerializationUtils.serialize(buildRedisSessionKey(id)));
            session = (Session) SerializationUtils.deserialize(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return session;
    }

    @Override
    public Collection<Session> getAllSessions() {
    	// TODO redis 3.0 keys()方法已删除, 此方法不再使用
        Set<Session> sessions = new HashSet<Session>();
        //logger.info("getAllSessions sessions:{}",sessions);
		return sessions;
    }

    private String buildRedisSessionKey(Serializable sessionId) {
        return REDIS_SHIRO_SESSION + sessionId;
    }

	public JedisCluster getJedisCluster() {
		return jedisCluster;
	}

	public void setJedisCluster(JedisCluster jedisCluster) {
		this.jedisCluster = jedisCluster;
	}


}
