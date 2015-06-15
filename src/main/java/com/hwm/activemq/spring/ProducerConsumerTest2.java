package com.hwm.activemq.spring;

import javax.annotation.Resource;
import javax.jms.Destination;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hwm.activemq.bo.IProducerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring.xml")
public class ProducerConsumerTest2 {

	@Autowired
	private IProducerService producerService;
	
	@Resource(name="queueDestination")
	private Destination destination;
	
	@Test
	public void testSend(){
		for(int i=0;i<2;i++){
//			producerService.sendMessage(destination, "你好，消费者！这事消息:" + i+1);
		}
	}
	
}
