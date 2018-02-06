package com.hub.data.springdataexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.hub"})
@EnableJpaRepositories(basePackages = {"com.hub"})
public class SpringDataExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataExampleApplication.class, args);
	}
}
