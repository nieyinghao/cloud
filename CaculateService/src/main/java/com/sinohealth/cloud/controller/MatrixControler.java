package com.sinohealth.cloud.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sinohealth.cloud.math.service.MatrixService;
import com.sinohealth.cloud.vo.DataFrame;
import com.sinohealth.cloud.vo.DataFramePlus;


@RestController
public class MatrixControler {
	@Resource
	MatrixService matrixService;
	
	@RequestMapping(value = "/matrix/inverse", method = RequestMethod.POST)
	public DataFramePlus matrixInverse(@RequestBody DataFrame df){
		
		double[][] datas = df.getDatas();
		DataFramePlus reultDf = matrixService.inverse(datas);
		return reultDf;

	}
	
	
	@RequestMapping(value = "/matrix/transpose", method = RequestMethod.POST, 
            consumes = "application/json")
	public DataFramePlus matrixTranspose(@RequestBody DataFrame df){
		
		double[][] datas = df.getDatas();
		DataFramePlus reultDf = matrixService.inverse(datas);
		
		return reultDf;
		
	}
	
	
	@RequestMapping(value = "/matrix/multiply", method = RequestMethod.POST,consumes = "application/json")
	public DataFramePlus multiply(@RequestBody DataFrame df){
		
		
		DataFramePlus res = matrixService.multiply(df.getDatas(), df.getDatas());
		
		
//		reultDf resultDf = new DataFramePlus();
		return res;
		
	}
	
	
	@RequestMapping(value = "/matrix/add", method = RequestMethod.POST,consumes = "application/json")
	public DataFramePlus add(@RequestBody DataFrame df){

		DataFramePlus res = matrixService.add(df.getDatas(), df.getDatas());
		
		return res;
		
	}
	
	
	
	
	@RequestMapping(value = "/matrix/binaryzation", method = RequestMethod.POST)
	public String binaryzation(@RequestBody String json){

		
		
		DataFramePlus[] beans = DataFramePlus.json2Bean(json, DataFramePlus[].class);

		DataFramePlus result = matrixService.binarization(beans);
	
		String resultJson = DataFramePlus.bean2Json(result);
		
		return resultJson;
		
	}
	
	
	
	
}
