package com.sinohealth.cloud.contorller;

import javax.annotation.Resource;

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
	
	public static final String DEPT_LIST_URL = "http://localhost:8080/linear/test";
	
	@RequestMapping(value = "/matrix/inverse", method = RequestMethod.GET)
	public String matrixInverse(String id){
		

		String flag = this.restTemplate.exchange(DEPT_LIST_URL, HttpMethod.GET,
				new HttpEntity<Object>( this.headers), String.class)
				.getBody();
		return flag;

	}
	
}
