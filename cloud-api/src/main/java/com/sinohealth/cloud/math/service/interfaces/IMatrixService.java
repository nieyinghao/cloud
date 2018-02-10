package com.sinohealth.cloud.math.service.interfaces;
import com.sinohealth.cloud.vo.DataFrame;
import com.sinohealth.cloud.vo.DataFramePlus;


public interface IMatrixService {

	public DataFramePlus inverse(double[][] datas);
	
	public DataFramePlus transpose(double[][] datas);
	
	public DataFramePlus multiply(double[][] data1,double[][] data2);
	
	

}
