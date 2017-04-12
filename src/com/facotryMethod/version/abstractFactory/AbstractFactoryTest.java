package com.facotryMethod.version.abstractFactory;

public class AbstractFactoryTest {
	
	public static void main(String[] args) {
		Provider p = new MailFactory();
		Sender s = p.produce();
		s.send();
		
		p = new SmsFactory();
		s = p.produce();
		s.send();
	}

}
