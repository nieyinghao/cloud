package com.sinohealth.cloud.contorller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class ComsumerControler {
	
	@Resource  
    private RestTemplate restTemplate; 
	
	@Resource
	private HttpHeaders headers;
	
	public static final String DEPT_LIST_URL = "http://caculate-service/linear/test";
//	public static final String DEPT_LIST_URL = "http://localhost:8080/linear/test";
	

	@RequestMapping(value = "/matrix/inverse111", method = RequestMethod.GET)
	public String matrixInverse(){
		
		
		
		String flag = restTemplate.exchange(DEPT_LIST_URL, HttpMethod.GET,
				new HttpEntity<Object>( this.headers), String.class)
				.getBody();
		
		String id = "成功啦";
		String flag2 = restTemplate.getForObject(DEPT_LIST_URL, String.class);
		
		
		
		return flag+","+flag2;

	}
	
}
