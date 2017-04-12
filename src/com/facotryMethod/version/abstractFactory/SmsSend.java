package com.facotryMethod.version.abstractFactory;

public class SmsSend implements Sender{

	@Override
	public void send() {
       System.out.println("This is sms sender");		
	}
	
	

}
