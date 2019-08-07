package com.mazdasales.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MazdaSalesWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MazdaSalesWsApplication.class, args);
	}

}
