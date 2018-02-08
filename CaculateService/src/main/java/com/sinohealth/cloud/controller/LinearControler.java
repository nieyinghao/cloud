//package com.sinohealth.cloud.controller;
//
//import java.io.IOException;
//import java.lang.reflect.Type;
//import java.util.Arrays;
//import java.util.List;
//
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.google.gson.reflect.TypeToken;
//
//import com.sinohealth.cloud.vo.DataFrame;
//import com.sinohealth.cloud.vo.DataFramePlus;
//
//
//
//@RestController
//public class LinearControler {
//	@RequestMapping(value = "/linear/multiply", method = RequestMethod.POST)
//	public String index(@RequestBody String json){
//		
//	
//		
//		
//		
//		DataFramePlus[] df = null;
//		try {
//			df = DataFramePlus.json2Bean(json, DataFramePlus[].class);
//			
//			Arrays.asList(df);	
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		double[][] x = df[0].getData();
//		double[] y = df[0].getData()[0];
//		
//		DataFramePlus haha = new LinearService().matrixMultiply(x, y);		
//
//		
//		
//		
//		return "";
//		
//	}
//}
