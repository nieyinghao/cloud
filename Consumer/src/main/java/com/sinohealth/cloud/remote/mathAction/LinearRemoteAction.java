package com.sinohealth.cloud.remote.mathAction;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.sinohealth.cloud.interfaces.math.Linear;
import com.sinohealth.cloud.vo.DataFrame;


@Service
public class LinearRemoteAction implements Linear {
	
	@Resource
	private RestTemplate  restTemplate;
	public DataFrame matrixMultiply(double[][] x, double[] y) {
		// TODO Auto-generated method stub
		String url = "http://localhost:8080/linear/multiply";
        //入参
        DataFrame df = new DataFrame();
		df.setData(y);
        df.setDatas(x);
        DataFrame responseBean = restTemplate.postForObject(url, df, DataFrame.class);
		return responseBean;
	}

}
