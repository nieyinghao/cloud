package com.sinohealth.cloud.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaServer
public class EurekaServerApp {

	
	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApp.class, args); //111111
		System.out.println("haha");

   
	} 
	
	
	
	
	

}
