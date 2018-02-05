package com.sinohealth.cloud.client;

import java.nio.charset.Charset;
import java.util.Base64;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.sinohealth.cloud.vo.DataFrame;

public class TestGet {
	
	public static void main(String[] args) {
		
		String url = "http://localhost:8080/matrix/multiply";
		RestTemplate restTemplate =  new RestTemplate();
		
		
		List<DataFrame> allDepts = restTemplate
				.exchange(url, HttpMethod.POST,
						new HttpEntity<Object>(TestGet.getHeader()), List.class)
				.getBody();
		
		
		

		
		
	}
	
	public void get() {
		
	}
	
	public static HttpHeaders getHeader() {
		HttpHeaders headers = new HttpHeaders(); // 定义一个HTTP的头信息
		String auth = "nyh:123456"; // 认证的原始信息
		byte[] encodedAuth = Base64.getEncoder()
				.encode(auth.getBytes(Charset.forName("US-ASCII"))); // 进行一个加密的处理
		// 在进行授权的头信息内容配置的时候加密的信息一定要与“Basic”之间有一个空格
		String authHeader = "Basic " + new String(encodedAuth);
		headers.set("Authorization", authHeader);
		
		return headers;
		
	}
	
	
}
