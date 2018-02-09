package com.sinohealth.cloud.contorller;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sinohealth.cloud.remote.mathAction.LinearRemoteAction;
import com.sinohealth.cloud.vo.DataFramePlus;


@RestController
public class ComsumerControler {
	
	@Resource  
    private RestTemplate restTemplate; 
	
	@Resource
	private HttpHeaders headers;
	
	@Resource 
	private LinearRemoteAction linearRemoteAction;
	
	public static final String DEPT_LIST_URL = "http://caculate-service/linear/test";
//	public static final String DEPT_LIST_URL = "http://localhost:8080/linear/test";
	

	@RequestMapping(value = "/matrix/inverse111", method = RequestMethod.GET)
	public String matrixInverse() throws IOException{
		
		
		double[][] x = { { 1 }, { 2 }, { 3 }, { 4 }, { 5 }, };
		double[] y = { 2, 3, 4, 5, 6 };
		
		
		
		DataFramePlus[] df = linearRemoteAction.matrixMultiply(x, y);
		
		
		
		
		System.out.println(DataFramePlus.bean2Json(df));
		
		return DataFramePlus.bean2Json(df);

	}
	
}
