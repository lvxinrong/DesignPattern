package com.facotryMethod.version.ordinary;

/**
 * 普通工厂方法就是，对实现了同一个接口的一些类进行实例的创建
 * 如果传递的字符串出错，则不能正确创建对象，而多个工厂方法模式是提供多个工厂方法，分别创建对象。
 */
public class SenderFactory {
	
	public Sender produce(String type) {  
        if ("mail".equals(type)) {  
            return new MailSend();  
        } else if ("sms".equals(type)) {  
            return new SmsSend();  
        } else {  
            System.out.println("请输入正确的类型!");  
            return null;  
        }  
    }  

}
