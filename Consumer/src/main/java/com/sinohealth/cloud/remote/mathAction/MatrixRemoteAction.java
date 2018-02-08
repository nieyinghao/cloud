package com.sinohealth.cloud.remote.mathAction;

import org.springframework.web.client.RestTemplate;

import com.sinohealth.cloud.math.service.interfaces.IMatrixService;
import com.sinohealth.cloud.vo.DataFrame;

public class MatrixRemoteAction implements IMatrixService {


	public DataFrame inverse(double[][] datas) {
		// TODO Auto-generated method stub
		String url = "http://localhost:8080/matrix/inverse";
        //入参
	        DataFrame df = new DataFrame();

	        df.setDatas(datas);
	        RestTemplate restTemplate = new RestTemplate();
	        DataFrame responseBean = restTemplate.postForObject(url, df, DataFrame.class);
			return responseBean;
	}

	public DataFrame transpose(double[][] datas) {
		// TODO Auto-generated method stub
		String url = "http://localhost:8080/matrix/transpose";
        //入参
	        DataFrame df = new DataFrame();

	        df.setDatas(datas);
	        RestTemplate restTemplate = new RestTemplate();
	        DataFrame responseBean = restTemplate.postForObject(url, df, DataFrame.class);
		return responseBean;
	}


	public DataFrame multiply(double[][] data1, double[][] data2) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}
