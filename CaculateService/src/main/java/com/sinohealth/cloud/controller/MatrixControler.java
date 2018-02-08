package com.sinohealth.cloud.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sinohealth.cloud.math.service.LinearService;
import com.sinohealth.cloud.math.service.MatrixService;
import com.sinohealth.cloud.vo.DataFrame;


@RestController
public class MatrixControler {
	@RequestMapping(value = "/matrix/inverse", method = RequestMethod.POST)
	public DataFrame matrixInverse(@RequestBody DataFrame df){
		
		double[][] datas = df.getDatas();
		DataFrame reultDf = new MatrixService().inverse(datas);
		return reultDf;

	}
	
	
	@RequestMapping(value = "/matrix/transpose", method = RequestMethod.POST, 
            consumes = "application/json")
	public DataFrame matrixTranspose(@RequestBody DataFrame df){
		
		double[][] datas = df.getDatas();
		DataFrame reultDf = new MatrixService().inverse(datas);
		
		return reultDf;
		
	}
	
	
	@RequestMapping(value = "/matrix/multiply", method = RequestMethod.POST,consumes = "application/json")
	public DataFrame multiply(@RequestBody DataFrame df){
		
		
		DataFrame res = new MatrixService().multiply(df.getDatas(), df.getDatas());
		
		
//		DataFrame resultDf = new DataFrame();
		return res;
		
	}
	
	
	@RequestMapping(value = "/matrix/add", method = RequestMethod.POST,consumes = "application/json")
	public DataFrame add(@RequestBody DataFrame df){

		DataFrame res = new MatrixService().add(df.getDatas(), df.getDatas());
		
		return res;
		
	}
	
	
	
	
	
	
	
	
	
}
