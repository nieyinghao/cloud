package com.sinohealth.cloud.interfaces.math;
import com.sinohealth.cloud.vo.DataFrame;


public interface Matrix {

	public DataFrame inverse(double[][] datas);
	
	public DataFrame transpose(double[][] datas);
	
	public DataFrame multiply(double[][] data1,double[][] data2);
	
	

}
