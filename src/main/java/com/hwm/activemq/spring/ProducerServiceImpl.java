package com.hwm.activemq.spring;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.hwm.activemq.bo.IProducerService;

public class ProducerServiceImpl implements IProducerService{

//	private static Logger log = Logger.getLogger(ProducerServiceImpl.class);
	
//	@Resource(name="jmsTemplate")
//	private JmsTemplate jmsTemplate;
//	
//	public JmsTemplate getJmsTemplate() {
//		return jmsTemplate;
//	}
//
//	@Resource
//	public void setJmsTemplate(JmsTemplate jmsTemplate) {
//		this.jmsTemplate = jmsTemplate;
//	}
	
	

	public void sendMessage(JmsTemplate jmsTemplate,Destination destination,String message) {
		System.out.println("=====生产者发送消息=====");
		System.out.println("生产者发送了一个消息：" + message);
		jmsTemplate.send(destination, new MessageCreator(){
			@Override
			public Message createMessage(Session session) throws JMSException {
				Message messages = session.createTextMessage(message);
				return messages;
			}
			
		});
	}

	/**
	 * 修改生产者：
	 * 	在发送消息之前先指定该消息对应的回复目的的队列目的地
	 */
	public void sendMessage(JmsTemplate jmsTemplate,Destination destination,Destination resDestination, String message) {
		System.out.println("=====生产者发送消息=====");
		System.out.println("生产者发送了一个消息：" + message);
		jmsTemplate.send(destination, new MessageCreator(){
			@Override
			public Message createMessage(Session session) throws JMSException {
				Message messages = session.createTextMessage(message);
				//在发送消息之前先指定该消息对应的回复目的的队列目的地
				messages.setJMSReplyTo(resDestination);
				return messages;
			}
			
		});
	}
//	@Override
//	public void sendMessage(Destination destination, Serializable object) {
//		jmsTemplate.send(destination, new MessageCreator(){
//			@Override
//			public Message createMessage(Session session) throws JMSException {
//				return session.createObjectMessage(object);
//			}});
//	}
	

}
