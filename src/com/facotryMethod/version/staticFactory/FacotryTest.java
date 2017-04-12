package com.facotryMethod.version.staticFactory;

public class FacotryTest {

	public static void main(String[] args) {  
        Sender sender = SenderFactory.getMailSend();
        sender.send();
    }  
}
