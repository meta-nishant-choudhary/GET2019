package com.metacube.mailsender.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component
public class MockMailSender implements MailSender{
	//@Bean
	@Override
	public String mailSender() {
		return "Sender send Mock mail";
	}

}
