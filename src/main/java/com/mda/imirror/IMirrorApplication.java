package com.mda.imirror;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class IMirrorApplication {

	public static void main(String[] args) {
		SpringApplication.run(IMirrorApplication.class, args);
	}

}
