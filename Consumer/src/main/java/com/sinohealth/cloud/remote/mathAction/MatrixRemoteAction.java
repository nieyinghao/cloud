package com.sinohealth.cloud.remote.mathAction;

import javax.annotation.Resource;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sinohealth.cloud.math.service.interfaces.IMatrixService;
import com.sinohealth.cloud.vo.DataFramePlus;

@Service
public class MatrixRemoteAction implements IMatrixService {

	@Resource
	RestTemplate restTemplate;
	
	public DataFramePlus inverse(double[][] datas) {
		// TODO Auto-generated method stub
		String url = "http://localhost:8080/matrix/inverse";
        //入参
	        DataFramePlus df = new DataFramePlus();

	        df.setData(datas);
	        RestTemplate restTemplate = new RestTemplate();
	        DataFramePlus responseBean = restTemplate.postForObject(url, df, DataFramePlus.class);
			return responseBean;
	}

	public DataFramePlus transpose(double[][] datas) {
		// TODO Auto-generated method stub
		String url = "http://localhost:8080/matrix/transpose";
        //入参
	        DataFramePlus df = new DataFramePlus();

	        df.setData(datas);
	        RestTemplate restTemplate = new RestTemplate();
	        DataFramePlus responseBean = restTemplate.postForObject(url, df, DataFramePlus.class);
		return responseBean;
	}


	public DataFramePlus multiply(double[][] data1, double[][] data2) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}
