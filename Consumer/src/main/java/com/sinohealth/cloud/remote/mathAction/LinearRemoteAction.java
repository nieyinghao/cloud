package com.sinohealth.cloud.remote.mathAction;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sinohealth.cloud.math.service.interfaces.ILinearService;
import com.sinohealth.cloud.vo.DataFramePlus;


@Service
public class LinearRemoteAction implements ILinearService {
	
	@Resource
	private RestTemplate  restTemplate;
	public DataFramePlus[] matrixMultiply(double[][] x, double[] y) {
		// TODO Auto-generated method stub
		String url = "http://CACULATE-SERVICE/linear/multiply";
        //入参
		DataFramePlus df = new DataFramePlus();
		DataFramePlus df2 = new DataFramePlus();
		double[][] haha = {y};
		
		df.setData(x);
		df2.setData(haha);
        
		
		
		
		DataFramePlus[] dfs = {df,df2};
		
		System.out.println("1"+DataFramePlus.bean2Json(dfs));
		String responseBean = null;

		responseBean = restTemplate.postForObject(url, DataFramePlus.bean2Json(dfs), String.class);

		dfs = DataFramePlus.json2Bean(responseBean, DataFramePlus[].class);
        
		return dfs;
	}

}
