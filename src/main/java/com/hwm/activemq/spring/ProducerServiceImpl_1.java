package com.hwm.activemq.spring;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.hwm.activemq.bo.IProducerService;

//@Component("producerService")
public class ProducerServiceImpl_1{

//	private static Logger log = Logger.getLogger(ProducerServiceImpl.class);
	
	@Resource(name="jmsTemplate")
	private JmsTemplate jmsTemplate;
	
	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	@Resource
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	

	
//	@Override
	public void sendMessage(Destination destination, String message) {
		jmsTemplate.send(destination, new MessageCreator(){
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createObjectMessage(message);
			}});
	}
	

}
