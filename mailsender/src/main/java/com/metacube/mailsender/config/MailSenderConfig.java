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
	/**
	 * bean class is used to construct object of SmtpMailSender class
	 * @return
	 */
	@Primary
	@Bean
	public MailSender smtpMailSender() {
		return new SmtpMailSender();
	}
	
	/**
	 * bean class is used to construct object of MockMailSender class
	 * @return
	 */
	@Bean
	public MailSender mockMailSender() {
		return new MockMailSender();
	}
}
