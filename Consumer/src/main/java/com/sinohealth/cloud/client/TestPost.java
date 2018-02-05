package com.sinohealth.cloud.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.sinohealth.cloud.vo.DataFrame;
import com.sinohealth.cloud.vo.ZzY2;
import com.sinohealth.cloud.remote.mathAction.LinearRemoteAction;
import com.sinohealth.cloud.remote.mathAction.MatrixRemoteAction;
import com.sinohealth.cloud.remote.mathAction.TemperatureDataImpl;



public class TestPost {
//	String url = "http://localhost:8080/matrixMultiply";
	
	
	public static void main(String[] args) {
		
		
		
		
		TemperatureDataImpl t = new TemperatureDataImpl();

	    List<ZzY2> haha = t.getByCityAndPeriod("南阳", "201603"); 
	    double[][] datas = new double[4][4];
	    
	    for(int i=0 ;i<4;i++){
	    	datas[i][0]=Double.parseDouble(haha.get(i).getPRE_D_T_1());
	    	datas[i][1]=Double.parseDouble(haha.get(i).getPRE_D_T_2());
	    	datas[i][2]=Double.parseDouble(haha.get(i).getPRE_D_T_4());
	    	datas[i][3]=Double.parseDouble(haha.get(i).getPRE_D_T_5());
	    }
		
		DataFrame df = new MatrixRemoteAction().inverse(datas);
		System.out.println(df.getIntercept());
		
		
		
		
		
		String url = "http://localhost:8080/matrix/multiply";
        //入参

	        
	        RestTemplate restTemplate = new RestTemplate();
	        
	        
	        DataFrame df1 = new DataFrame();
//	        df1.setDatas(datas);
//	        
//	        DataFrame df2 = new DataFrame();
	        df1.setDatas(datas);
	        Map<String,DataFrame> map = new HashMap<String,DataFrame>();
	        
	        Map<String,double[][]> map2 = new HashMap<String,double[][]>();
	        
	        map2.put("var1", datas);
	        map2.put("var2", datas);
	        
	        df1.setMap(map2);

	        
	        
	        DataFrame responseBean = restTemplate.postForObject(url, df1, DataFrame.class);
		
		
	        
	        
	        
	        System.out.println(responseBean);

//		
//		df = new MatrixRemoteAction().transpose(datas);
		
		
		
		
		
//		System.out.println(responseBean);
		

	}
	
	
	public void multieLinear() {
	    TemperatureDataImpl t = new TemperatureDataImpl();
	    List<ZzY2> haha = t.getByCityAndPeriod("南阳", "201603"); 
	    double[][] datas = new double[haha.size()][4];
	    double[] y = new double[haha.size()];
	    
	    for(int i=0 ;i<haha.size();i++){
	    	datas[i][0]=Double.parseDouble(haha.get(i).getPRE_D_T_1());
	    	datas[i][1]=Double.parseDouble(haha.get(i).getPRE_D_T_2());
	    	datas[i][2]=Double.parseDouble(haha.get(i).getPRE_D_T_4());
	    	datas[i][3]=Double.parseDouble(haha.get(i).getPRE_D_T_5());
	    	y[i]=Double.parseDouble(haha.get(i).getPRE_D_T_3());
	    }
	    
	    DataFrame df = new LinearRemoteAction().matrixMultiply(datas, y);
	    System.out.println(df.coefficientsToString());
	    System.out.println(df);
	    
	    
	}
	
	
	
	
	
	
	
	

	
}
