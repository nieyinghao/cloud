package com.sinohealth.cloud.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@EnableDiscoveryClient
@ComponentScan(basePackages = { "com.sinohealth.cloud" })
//@MapperScan(basePackages="com.sinohealth.dsc.mapper")
public class CaculateServiceApp {

	
	public static void main(String[] args) {
		SpringApplication.run(CaculateServiceApp.class, args); //111111
		System.out.println("haha");

   
	} 
	
	
	
	
	

}
