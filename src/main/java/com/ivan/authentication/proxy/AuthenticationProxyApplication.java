package com.ivan.authentication.proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AuthenticationProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationProxyApplication.class, args);
	}

}
