package com.kafeel.tracetheip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kafeel.tracetheip.config.AppConfig;

@SpringBootApplication
public class TraceTheIpApplication {

	public static void main(String[] args) {
		SpringApplication.run(TraceTheIpApplication.class, args);
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	}

}
