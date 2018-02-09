package com.sinohealth.cloud.contorller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sinohealth.cloud.remote.mathAction.LinearRemoteAction;
import com.sinohealth.cloud.remote.mathAction.MatrixRemoteAction;
import com.sinohealth.cloud.vo.DataFramePlus;


@RestController
public class ComsumerControler {
	
	@Resource MatrixRemoteAction matrixRemoteAction;
	
	@Resource
	private HttpHeaders headers;
	
	@Resource 
	private LinearRemoteAction linearRemoteAction;
	
	public static final String DEPT_LIST_URL = "http://caculate-service/linear/test";
//	public static final String DEPT_LIST_URL = "http://localhost:8080/linear/test";
	

	@RequestMapping(value = "/matrix/inverse111", method = RequestMethod.GET)
	public String matrixInverse() throws IOException{
		
		
		double[][] x = { { 1 }, { 2 }, { 3 }, { 4 }, { 5 }, };
		double[] y = { 2, 3, 4, 5, 6 };
		
		
		
		DataFramePlus[] df = linearRemoteAction.matrixMultiply(x, y);
		
		
		
		
		System.out.println(DataFramePlus.bean2Json(df));
		
		return DataFramePlus.bean2Json(df);

	}
	
	
	@RequestMapping(value = "/matrix/binaryzation", method = RequestMethod.GET)
	public String binaryzation() throws IOException{
		
		double[][] datas = {{-1,2,5},{2,5.6,4}};
		double[] thresholdVector = {2,5.6,1};
		DataFramePlus a = new DataFramePlus();
		a.setData(datas);
	
		DataFramePlus b = new DataFramePlus();
		b.setData(new double[][]{thresholdVector});
		
		List<DataFramePlus> list = new ArrayList<DataFramePlus>();
		list.add(a);
		list.add(b);
		System.out.println(list.size());
		DataFramePlus[] array = {a,b};
		DataFramePlus result = matrixRemoteAction.binarization(array);
		
		return DataFramePlus.bean2Json(result);

	}
	
	
	
}
