package com.mda.imirror;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//@PropertySource(value = { "classpath:database.properties"}) //local environment
public class IMirrorApplication {

	public static void main(String[] args) {
		SpringApplication.run(IMirrorApplication.class, args);
	}

}
