package com.jgcolab.mymenu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan("com.jgcolab.mymenu.domain")
@EnableJpaRepositories("com.jgcolab.mymenu.repository")
public class MymenuApplication {

	public static void main(String[] args) {
		SpringApplication.run(MymenuApplication.class, args);
	}

}
