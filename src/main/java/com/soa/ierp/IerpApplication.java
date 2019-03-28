package com.soa.ierp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class IerpApplication {

	public static void main(String[] args) {
		SpringApplication.run(IerpApplication.class, args);
	}

}
