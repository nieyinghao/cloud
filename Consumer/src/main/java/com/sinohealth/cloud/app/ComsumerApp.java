package com.sinohealth.cloud.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@ComponentScan(basePackages = { "com.sinohealth.cloud" })
public class ComsumerApp {

	public static void main(String[] args) {
		SpringApplication.run(ComsumerApp.class, args); //
		
		System.out.println("haha");
		
		
	

	} 
	

}
