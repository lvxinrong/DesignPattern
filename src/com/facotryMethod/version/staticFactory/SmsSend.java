package com.facotryMethod.version.staticFactory;

public class SmsSend implements Sender{

	@Override
	public void send() {
       System.out.println("This is sms sender");		
	}
	
	

}
