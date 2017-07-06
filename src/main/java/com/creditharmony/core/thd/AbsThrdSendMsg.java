package com.creditharmony.core.thd;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbsThrdSendMsg extends AbsThread implements IThrdSendMsg {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private final String strCname = this.getClass().getName();
	
	private String strMsg;
	public void setMsg(String strMsg) {
		this.strMsg = strMsg;
	}
	private String strSys;
	public void setSys(String strSys){
		this.strSys = strSys;
	}
	protected void sendMsg(String strFlg, Properties pptMq){
		String strFname = " sendMsg : ";
		
		// 默认连接用户名
		String USERNAME = null; //ActiveMQConnection.DEFAULT_USER;
		// 默认连接密码
		String PASSWORD = null; //ActiveMQConnection.DEFAULT_PASSWORD;
		// 默认连接地址
		String BROKEURL = null; //ActiveMQConnection.DEFAULT_BROKER_URL;
		// 发送的消息数量
//		int SENDNUM = 10;
		
		// 连接工厂
		ConnectionFactory connectionFactory;
		// 连接
		Connection connection = null;
		// 会话 接受或者发送消息的线程
		Session session;
		// 消息的目的地
		Destination destination;
		// 消息生产者
		MessageProducer messageProducer;
		// 创建一条文本消息
		TextMessage message = null;

		
		try {
			if(pptMq!=null && strMsg!=null && strMsg.trim().length()>0){
				// 默认连接用户名
				USERNAME = null; //pptMq.getProperty("USERNAME");
				// 默认连接密码
				PASSWORD = null; //pptMq.getProperty("PASSWORD");
				// 默认连接地址
				BROKEURL = "failover:"+pptMq.getProperty("BROKEURL"); // "failover://tcp://"+pptMq.getProperty("BROKEURL");
//				// 默认连接用户名
//				USERNAME = ActiveMQConnection.DEFAULT_USER;
//				// 默认连接密码
//				PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
//				// 默认连接地址
//				BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;
				
				// 实例化连接工厂
				connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKEURL);
				// 通过连接工厂获取连接
				connection = connectionFactory.createConnection();
				// 启动连接
				connection.start();
				// 创建session
				session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
				// 创建一个名称为HelloWorld的消息队列
//				destination = session.createQueue("HelloWorld");
				destination = session.createQueue(strSys);
				// 创建消息生产者
				messageProducer = session.createProducer(destination);

				// 发送消息
				// 创建一条文本消息
				message = session.createTextMessage(strFlg + "||"+ strMsg);
//				System.out.println("发送消息：Activemq 发送消息");
				// 通过消息生产者发出消息
				messageProducer.send(message);
				//
				session.commit();
			}
		} catch(Exception ex) {
			long lonFlg = System.currentTimeMillis();
			logger.error(strCname + strFname + ex + "||" + lonFlg);
			StackTraceElement[] subSte = ex.getStackTrace();
			for(int i=0; i<subSte.length; i++){
				logger.error(
						subSte[i].getClassName() 
						+ subSte[i].getMethodName() 
						+ ":" + subSte[i].getLineNumber() 
						+ "||" + lonFlg );
			}
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
