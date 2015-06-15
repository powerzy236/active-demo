package com.hwm.activemq.spring;

import javax.jms.Destination;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import com.hwm.activemq.bo.IProducerService;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath*:activemq.xml")
public class ProducerConsumerTest {

//	@Autowired
//	private IProducerService producerService;
	
//	@Autowired
//	@Qualifier("queueDestination")
//	private Destination destination;
	
	/*@Test
	public void testSend(){
		for(int i=0;i<2;i++){
			producerService.sendMessage(destination, "你好，消费者！这事消息:" + i+1);
		}
	}*/
	
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("activemq.xml");
		// 获得JMS 模板
		JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsTemplate");
		IProducerService producerService = new ProducerServiceImpl();
		
		/**
		 * 简单Queue测试
		 */
		Destination destination = (Destination) context
				.getBean("queueDestination");
		for(int i=0;i<10;i++){
			producerService.sendMessage(jmsTemplate,destination, "你好，消费者！这事消息:" + i+1);
		}
		/**
		 * sessionAwareQueue测试
		 */
		// 获得发送消息的目的地
//		Destination destination = (Destination) context
//				.getBean("sessionAwareQueue");
//		for(int i=0;i<2;i++){
//			producerService.sendMessage(jmsTemplate,destination, "你好，消费者！这事消息:" + i+1);
//		}
		
		/**
		 * 适配器测试
		 */
//		Destination destination = (Destination) context
//				.getBean("adapterQueue");
//		Destination resDestination = (Destination) context
//				.getBean("responseQueue");
//		producerService.sendMessage(jmsTemplate, destination,resDestination, "测试MessageListenerAdapter");
//		for(int i=0;i<2;i++){
//			producerService.sendMessage(jmsTemplate, destination, "测试MessageListenerAdapter"+ i);
//		}
	}
}
