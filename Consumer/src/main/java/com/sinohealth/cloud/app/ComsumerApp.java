package com.sinohealth.cloud.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.ComponentScan;
	

@SpringBootApplication
@ComponentScan(basePackages = { "com.sinohealth.cloud" })
@EnableEurekaClient
public class ComsumerApp {

	public static void main(String[] args) {
		SpringApplication.run(ComsumerApp.class, args); //
		
		System.out.println("haha");
		

	} 
	

}
