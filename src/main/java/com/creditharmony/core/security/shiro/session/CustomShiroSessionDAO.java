package com.creditharmony.core.security.shiro.session;

import java.io.Serializable;
import java.util.Collection;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 自定义的基于shiro的sessionDao
 * @Class Name CustomShiroSessionDAO
 * @author 张永生
 * @Create In 2016年1月14日
 */
public class CustomShiroSessionDAO extends AbstractSessionDAO {

    private ShiroSessionRepository shiroSessionRepository;
    
    private static final Logger logger = LoggerFactory.getLogger(CustomShiroSessionDAO.class);
    
    @Override
    public void update(Session session) throws UnknownSessionException {
    	//logger.info("update sessionId:{}",session.getId());
        getShiroSessionRepository().saveSession(session);
    }

    @Override
    public void delete(Session session) {
        if (session == null) {
            return;
        }
        Serializable id = session.getId();
        //logger.info("delete sessionId:{}",id);
        if (id != null) {
            getShiroSessionRepository().deleteSession(id);
        }
    }

    @Override
    public Collection<Session> getActiveSessions() {
        // TODO redis 3.0 keys()方法已删除, 此方法不再使用
    	//logger.info("getActiveSessions msg:{}","获取所有session");
        return null;
    }

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = this.generateSessionId(session);
       // logger.info("doCreate sessionId:{}",sessionId);
        this.assignSessionId(session, sessionId);
        getShiroSessionRepository().saveSession(session);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
    	//logger.info("doReadSession sessionId:{}",sessionId);
        return getShiroSessionRepository().getSession(sessionId);
    }

    public ShiroSessionRepository getShiroSessionRepository() {
        return shiroSessionRepository;
    }

    public void setShiroSessionRepository(
            ShiroSessionRepository shiroSessionRepository) {
        this.shiroSessionRepository = shiroSessionRepository;
    }

}
