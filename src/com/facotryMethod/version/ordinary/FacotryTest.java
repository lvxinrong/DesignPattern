package com.facotryMethod.version.ordinary;

public class FacotryTest {

	public static void main(String[] args) {  
		SenderFactory factory = new SenderFactory();  
        Sender sender = factory.produce("sms");  
        sender.send();
    }  
}
