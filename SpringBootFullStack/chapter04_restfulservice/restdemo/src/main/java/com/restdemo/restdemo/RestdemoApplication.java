package com.restdemo.restdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestdemoApplication {

	public static void main(String[] args) {
		// System.setProperty("spring.devtools.restart.enabled", false); // 禁用自动重启
		SpringApplication.run(RestdemoApplication.class, args);
	}

}
