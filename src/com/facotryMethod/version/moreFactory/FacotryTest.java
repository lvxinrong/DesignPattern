package com.facotryMethod.version.moreFactory;

public class FacotryTest {

	public static void main(String[] args) {  
		SenderFactory factory = new SenderFactory();  
        Sender sender = factory.getMailSend();
        sender.send();
    }  
}
