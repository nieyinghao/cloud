package com.sinohealth.cloud.math.service.interfaces;
import com.sinohealth.cloud.vo.DataFrame;


public interface IMatrixService {

	public DataFrame inverse(double[][] datas);
	
	public DataFrame transpose(double[][] datas);
	
	public DataFrame multiply(double[][] data1,double[][] data2);
	
	

}
