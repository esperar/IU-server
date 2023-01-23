package com.IU;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class IuApplication {

	public static void main(String[] args) {
		SpringApplication.run(IuApplication.class, args);
	}

}
