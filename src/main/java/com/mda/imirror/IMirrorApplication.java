package com.mda.imirror;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableJpaAuditing
@EnableRedisHttpSession
@PropertySource("classpath:/application.properties")
public class IMirrorApplication {

	public static void main(String[] args) {
		SpringApplication.run(IMirrorApplication.class, args);
	}

}
