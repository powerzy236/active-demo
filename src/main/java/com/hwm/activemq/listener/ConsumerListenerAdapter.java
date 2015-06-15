package com.hwm.activemq.listener;

/**
 * MessageListenerAdapter类实现了MessageListener接口和SessionAwareMessageListener接口，
 * 它的主要作用是将接收到的消息进行类型转换，然后通过反射的形式把它交给一个普通的Java类进行处理。
       MessageListenerAdapter会把接收到的消息做如下转换：
       TextMessage转换为String对象；
       BytesMessage转换为byte数组；
       MapMessage转换为Map对象；
       ObjectMessage转换为对应的Serializable对象。
   
    MessageListenerAdapter除了会自动的把一个普通Java类当做MessageListener
            来处理接收到的消息之外， 其另外一个主要的功能是可以自动的发送返回消息。
       
   测试结果：
   	使用方法1的情况下：默认调用handleMessage();
   	使用方法2的情况下：指定调用方法，指定了receiveMessage();
   	
   测试自动的发送返回消息：
   	统一使用方法2的调用方式，指定固定的返回值;
   实现方式：
   1.在生产者中，可以通过发送的Message的setJMSReplyTo方法指定该消息对应的回复消息的目的地，
   	对于MessageListenerAdapter对应的监听器处理方法返回的是一个null值或者返回类型是void的情况，
   	MessageListenerAdapter是不会自动进行消息的回复的。回复的目的在于setJMSReplyTo的目的地；
   	
   2.通过MessageListenerAdapter的defaultResponseDestination属性来指定。
   	这里我们也来做一个测试，首先维持生产者发送消息的代码不变，
   	即发送消息前不通过Message的setJMSReplyTo方法指定消息的回复目的地；
   	接着我们在定义MessageListenerAdapter的时候通过其defaultResponseDestination
   	属性指定其默认的回复目的地是“defaultResponseQueue”，
   	并定义defaultResponseQueue对应的消息监听器和消息监听容器。
 * @author 黄韦谋
 * @data 2015年6月15日 下午3:28:14
 */
public class ConsumerListenerAdapter{

	public String handleMessage(String message) {   
        System.out.println("ConsumerListenerAdapter通过handleMessage接收到一个纯文本消息，消息内容是：" + message);   
        return "这个是ConsumerListenerAdapter对象handleMessage方法的返回值。";
    }   
       
    public String receiveMessage(String message) {   
        System.out.println("ConsumerListenerAdapter通过receiveMessage接收到一个纯文本消息，消息内容是：" + message);   
        return "这个是ConsumerListenerAdapter对象receiveMessage方法的返回值。";
    }   
}
