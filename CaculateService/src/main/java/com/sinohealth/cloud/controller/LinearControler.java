package com.sinohealth.cloud.controller;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sinohealth.cloud.math.service.LinearService;
import com.sinohealth.cloud.vo.DataFramePlus;



@RestController
public class LinearControler {
	@RequestMapping(value = "/linear/multiply", method = RequestMethod.POST)
	public String index(@RequestBody String json){
		
	
		System.out.println("hahaha"+json);
		
		
		DataFramePlus[] df = null;

		df = DataFramePlus.json2Bean(json, DataFramePlus[].class);
		
		Arrays.asList(df);	
		System.out.println("来到这里了");

		
		
		double[][] x = df[0].getData();
		double[] y = df[1].getData()[0];
		
		DataFramePlus[] haha = new LinearService().matrixMultiply(x, y);		

		
//		DataFramePlus.bean2Json(haha);
		return DataFramePlus.bean2Json(haha);
		
	}
}
