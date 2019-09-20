package com.metacube.hibernate1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude=HibernateJpaAutoConfiguration.class)
public class Hibernate1Application {

	public static void main(String[] args) {
		SpringApplication.run(Hibernate1Application.class, args);
	}

}
