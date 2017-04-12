package com.facotryMethod.version.moreFactory;

/**
 * 普通工厂方法就是，对实现了同一个接口的一些类进行实例的创建
 * 如果传递的字符串出错，则不能正确创建对象，而多个工厂方法模式是提供多个工厂方法，分别创建对象。
 */
public class SenderFactory {
	
	public Sender getMailSend() {  
       return new MailSend();
    }  
	
	public Sender getSmsSend() {
		return new SmsSend();
	}
}
