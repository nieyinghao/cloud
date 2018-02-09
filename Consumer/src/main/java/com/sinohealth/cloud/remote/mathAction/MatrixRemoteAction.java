package com.sinohealth.cloud.remote.mathAction;

import java.util.ArrayList;
import java.util.List;

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
		String url = "http://CACULATE-SERVICE/matrix/inverse";
        //入参
	        DataFramePlus df = new DataFramePlus();

	        df.setData(datas);
	        DataFramePlus responseBean = restTemplate.postForObject(url, df, DataFramePlus.class);
			return responseBean;
	}

	public DataFramePlus transpose(double[][] datas) {
		// TODO Auto-generated method stub
		String url = "http://CACULATE-SERVICE/matrix/transpose";
        //入参
	        DataFramePlus df = new DataFramePlus();

	        df.setData(datas);

	        DataFramePlus responseBean = restTemplate.postForObject(url, df, DataFramePlus.class);
		return responseBean;
	}


	public DataFramePlus multiply(double[][] data1, double[][] data2) {
		// TODO Auto-generated method stub
		return null;
	}

	public DataFramePlus binarization(DataFramePlus[] dps) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String url = "http://CACULATE-SERVICE/matrix/binaryzation";
		
		double[][] datas = {{-1,2,5},{2,5.6,4}};
		double[] thresholdVector = {2,5.6,1};
		DataFramePlus a = new DataFramePlus();
		a.setData(datas);
	
		DataFramePlus b = new DataFramePlus();
		b.setData(new double[][]{thresholdVector});
		
		List<DataFramePlus> list = new ArrayList<DataFramePlus>();
		list.add(a);
		list.add(b);
		System.out.println("haha:"+list.size());

		String responseJson = restTemplate.postForObject(url, DataFramePlus.bean2Json(list), String.class);
		DataFramePlus result = DataFramePlus.json2Bean(responseJson, DataFramePlus.class);
		
		return result;
	}


	
	
	
	

}
