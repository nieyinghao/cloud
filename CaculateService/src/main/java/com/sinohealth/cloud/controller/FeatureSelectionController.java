package com.sinohealth.cloud.controller;

import java.util.Arrays;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sinohealth.cloud.math.service.LinearService;
import com.sinohealth.cloud.vo.DataFramePlus;

/**
 * 特征选择接口控制器
 * @author ling
 *
 */
@RestController
public class FeatureSelectionController { 
	
	
	@RequestMapping(value = "/feature_selection/VarianceThreshold", method = RequestMethod.POST)
	public String varianceThreshold(@RequestBody String json, String threshold){
		DataFramePlus df = DataFramePlus.json2Bean(json, DataFramePlus.class);
		return null;
		
	}
}
