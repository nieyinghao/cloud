package com.sinohealth.cloud.remote.mathAction;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sinohealth.cloud.math.service.interfaces.ILinearService;
import com.sinohealth.cloud.vo.DataFrame;
import com.sinohealth.cloud.vo.DataFramePlus;


@Service
public class LinearRemoteAction implements ILinearService {
	
	@Resource
	private RestTemplate  restTemplate;
	public DataFramePlus matrixMultiply(double[][] x, double[] y) {
		// TODO Auto-generated method stub
		String url = "http://localhost:8080/linear/multiply";
        //入参
        DataFrame df = new DataFrame();
		df.setData(y);
        df.setDatas(x);
        DataFramePlus responseBean = restTemplate.postForObject(url, df, DataFramePlus.class);
		return responseBean;
	}

}
