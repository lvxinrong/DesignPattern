package com.facotryMethod.version.abstractFactory;

public class MailSend implements Sender{

	@Override
	public void send() {
		System.out.println("This is mail send");
	}

}
