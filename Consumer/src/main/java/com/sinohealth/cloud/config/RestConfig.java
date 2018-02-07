package com.sinohealth.cloud.config;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {
	


	@Bean
	public HttpHeaders getHeaders() { // 
		HttpHeaders headers = new HttpHeaders(); // 
//		String auth = "nyh:123456"; 
//		byte[] encodedAuth = Base64.getEncoder()
//				.encode(auth.getBytes(Charset.forName("US-ASCII"))); 
//
//		String authHeader = "Basic " + new String(encodedAuth);
//		headers.set("Authorization", authHeader);
		return headers;
	}
	
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
//    @Bean
//    RestTemplate restTemplate() {
//        return new RestTemplate();
//    }
	
	
}
