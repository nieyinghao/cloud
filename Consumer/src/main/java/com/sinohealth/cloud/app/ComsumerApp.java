package com.sinohealth.cloud.app;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;


@EnableAutoConfiguration
@EnableDiscoveryClient
@ComponentScan(basePackages = { "com.mcc"})
@MapperScan(basePackages="com.mcc.mybatis.dao")
public class ComsumerApp {

	public static void main(String[] args) {
		SpringApplication.run(ComsumerApp.class, args); //
		
		System.out.println("haha");
		
//		double[][] x = { { 2,3 }, { 2,4 }, {2,5 }, { 2,6 }, {2,7 }, };
//		double[] y = { 2, 3, 4, 5, 6 };
//		
//
//		String haha = new LinearImpl().matrixMultiply(x, y);
//		System.out.println(haha);

	} 
	
	
	
	
	

}
