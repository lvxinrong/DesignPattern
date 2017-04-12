package com.facotryMethod.version.abstractFactory;

public class MailFactory implements Provider{

	@Override
	public Sender produce() {
		return new MailSend();
	}

}
