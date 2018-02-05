package com.sinohealth.cloud.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sinohealth.cloud.vo.DataFrame;
import com.sinohealth.cloud.impl.math.LinearImpl;
import com.sinohealth.cloud.impl.math.MatrixImpl;


@RestController
public class MatrixControler {
	@RequestMapping(value = "/matrix/inverse", method = RequestMethod.POST)
	public DataFrame matrixInverse(@RequestBody DataFrame df){
		
		double[][] datas = df.getDatas();
		DataFrame reultDf = new MatrixImpl().inverse(datas);
		return reultDf;

	}
	
	
	@RequestMapping(value = "/matrix/transpose", method = RequestMethod.POST, 
            consumes = "application/json")
	public DataFrame matrixTranspose(@RequestBody DataFrame df){
		
		double[][] datas = df.getDatas();
		DataFrame reultDf = new MatrixImpl().inverse(datas);
		
		return reultDf;
		
	}
	
	
	@RequestMapping(value = "/matrix/multiply", method = RequestMethod.POST,consumes = "application/json")
	public DataFrame multiply(@RequestBody DataFrame df){
		
		
		DataFrame res = new MatrixImpl().multiply(df.getDatas(), df.getDatas());
		
		
//		DataFrame resultDf = new DataFrame();
		return res;
		
	}
	
	
	@RequestMapping(value = "/matrix/add", method = RequestMethod.POST,consumes = "application/json")
	public DataFrame add(@RequestBody DataFrame df){

		DataFrame res = new MatrixImpl().add(df.getDatas(), df.getDatas());
		
		return res;
		
	}
	
	
	
	
	
	
	
	
	
}
