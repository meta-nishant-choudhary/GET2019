package com.metacube.mailsender.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.metacube.mailsender.services.MailSender;
import com.metacube.mailsender.services.MockMailSender;
import com.metacube.mailsender.services.SmtpMailSender;

@Configuration
public class MailSenderConfig {
	
	@Bean
	public MailSender smtpMailSender() {
		System.out.println("bean method");
		return new SmtpMailSender();
	}
	
	@Bean
	public MailSender mockMailSender() {
		return new MockMailSender();
	}
}
