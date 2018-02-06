package com.sinohealth.cloud.contorller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ComsumerControler {
	@RequestMapping(value = "/matrix/inverse", method = RequestMethod.GET)
	public String matrixInverse(String id){
		

		
		
		
		
		return "ok";

	}
	
	

	
	
	
	
	
	
	
	
	
}
