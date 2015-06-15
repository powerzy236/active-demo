package com.hwm.activemq.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
/**
 * MessageListener是最原始的消息监听器，它是JMS规范中定义的一个接口。
 * 其中定义了一个用于处理接收到的消息的onMessage方法，该方法只接收一个Message参数
 * @author 黄韦谋
 * @data 2015年6月15日 上午11:50:17
 */
public class CusumerMessageListener implements MessageListener {

//	private static Logger log = Logger.getLogger(CusumerMessageListener.class);
	@Override
	public void onMessage(Message message) {
		//TextMessage是Message子类，因已知接收信息是个text，所以进行强转
		TextMessage textMessage = (TextMessage) message;
		System.out.println("====接收到一个信息 ===");
		try {
			System.out.println("消息内容是：" + textMessage.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
