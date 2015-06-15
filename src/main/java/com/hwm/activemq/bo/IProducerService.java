package com.hwm.activemq.bo;

import javax.jms.Destination;

import org.springframework.jms.core.JmsTemplate;

public interface IProducerService {

//	public void sendMessage(Destination destination, String message);
	
	public void sendMessage(JmsTemplate jmsTemplate,Destination destination, String message);
//	
//	public void sendMessage(JmsTemplate jmsTemplate,Destination destination,Destination resDestination, String message); 
//	public void sendMessage(Destination destination, Serializable object);
}
