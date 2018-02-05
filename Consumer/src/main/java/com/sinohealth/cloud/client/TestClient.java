package com.sinohealth.cloud.client;
import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.sinohealth.cloud.remote.mathAction.LinearRemoteAction;
import com.sinohealth.cloud.vo.DataFrame;
@EnableAutoConfiguration
@EnableDiscoveryClient
@ComponentScan(basePackages = { "com.sinohealth.cloud" })
//@MapperScan(basePackages="com.sinohealth.dsc.mapper")
public class TestClient {
	
	@Resource
	 LinearRemoteAction linearRemoteAction;
	public static void main(String[] args) {
		
		ConfigurableApplicationContext cx = SpringApplication.run(TestClient.class, args); //
		
//		TestClient t = (TestClient)cx.getBean(TestClient.class);
//		t.test();
//		cx.close();
	}
	
	public  void test() {
		double[][] x = { { 2,3 }, { 2,4 }, {2,5 }, { 2,6 }, {2,7 }, };
		double[] y = { 2, 3, 4, 5, 6 };
//		Linear re = new LinearRemoteAction();

		DataFrame ha = linearRemoteAction.matrixMultiply(x, y);
		for(double h : ha.getCoefficients()) {
			System.out.println("h:"+h);
		}
	}
}
