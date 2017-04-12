package com.facotryMethod.version.abstractFactory;

public class SmsFactory implements Provider{

	@Override
	public Sender produce() {
		return new SmsSend();
	}

}
