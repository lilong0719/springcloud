package com.ll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
@EnableAuthorizationServer
@EnableJpaRepositories(basePackages = "com.service")
@EntityScan(basePackages = "com.entity")
public class SpringSecuritySsoAuthServerApplication{

	public static void main(String[] args) {
		SpringApplication.run(SpringSecuritySsoAuthServerApplication.class, args);
	}
}
