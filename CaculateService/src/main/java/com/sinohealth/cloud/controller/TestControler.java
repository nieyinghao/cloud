package com.sinohealth.cloud.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sinohealth.cloud.math.service.LinearService;
import com.sinohealth.cloud.vo.DataFrame;


@RestController
public class TestControler {
	@RequestMapping(value = "/linear/test",method=RequestMethod.GET)
	public Object index(){
		
		double[][] x = {{1,2},{3,4}};
		double[] y = {1,2};

		return "good!!";
		
	}
}
