package com.servletdemo.servletdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class ServletdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServletdemoApplication.class, args);
	}

}
