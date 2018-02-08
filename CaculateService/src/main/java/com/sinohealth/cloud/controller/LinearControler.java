package com.sinohealth.cloud.controller;

import java.lang.reflect.Type;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.reflect.TypeToken;
import com.sinohealth.cloud.math.service.LinearService;
import com.sinohealth.cloud.vo.DataFrame;
import com.sinohealth.cloud.vo.DataFramePlus;



@RestController
public class LinearControler {
	@RequestMapping(value = "/linear/multiply", method = RequestMethod.POST)
	public String index(@RequestBody String json){
		
		
		Type type = new TypeToken<List<DataFramePlus>>() {}.getType(); 
		
		
		
		List<DataFramePlus> df =null;
		
		
		double[][] x = df.get(0).getData();
		double[] y = df.get(0).getData()[0];
		
		
		DataFrame haha = new LinearService().matrixMultiply(x, y);		

		
		
		
		return "";
		
	}
}
