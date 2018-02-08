package com.sinohealth.cloud.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sinohealth.cloud.math.service.MatrixService;
import com.sinohealth.cloud.vo.DataFrame;
import com.sinohealth.cloud.vo.DataFramePlus;


@RestController
public class MatrixControler {
	@RequestMapping(value = "/matrix/inverse", method = RequestMethod.POST)
	public DataFramePlus matrixInverse(@RequestBody DataFrame df){
		
		double[][] datas = df.getDatas();
		DataFramePlus reultDf = new MatrixService().inverse(datas);
		return reultDf;

	}
	
	
	@RequestMapping(value = "/matrix/transpose", method = RequestMethod.POST, 
            consumes = "application/json")
	public DataFramePlus matrixTranspose(@RequestBody DataFrame df){
		
		double[][] datas = df.getDatas();
		DataFramePlus reultDf = new MatrixService().inverse(datas);
		
		return reultDf;
		
	}
	
	
	@RequestMapping(value = "/matrix/multiply", method = RequestMethod.POST,consumes = "application/json")
	public DataFramePlus multiply(@RequestBody DataFrame df){
		
		
		DataFramePlus res = new MatrixService().multiply(df.getDatas(), df.getDatas());
		
		
//		reultDf resultDf = new DataFramePlus();
		return res;
		
	}
	
	
	@RequestMapping(value = "/matrix/add", method = RequestMethod.POST,consumes = "application/json")
	public DataFramePlus add(@RequestBody DataFrame df){

		DataFramePlus res = new MatrixService().add(df.getDatas(), df.getDatas());
		
		return res;
		
	}
	
	
	
	
	
	
	
	
	
}
