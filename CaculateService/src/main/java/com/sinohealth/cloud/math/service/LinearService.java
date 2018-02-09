package com.sinohealth.cloud.math.service;


import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;

import com.sinohealth.cloud.math.service.interfaces.ILinearService;
import com.sinohealth.cloud.vo.DataFramePlus;

public class LinearService implements ILinearService {


	public DataFramePlus[] matrixMultiply(double[][] x,double[] y) {
				DataFramePlus resultDf= new DataFramePlus();
				DataFramePlus resultDf2 = new DataFramePlus();
				try {
					// TODO Auto-generated method stub
					final OLSMultipleLinearRegression regression2 = new OLSMultipleLinearRegression();  
		  
					regression2.newSampleData(y, x);  
					double[] beta = regression2.estimateRegressionParameters();  
					for (double d : beta) {  
					    System.out.println("D: " + d);  
					}  
					
					double sumOfSquares = regression2.calculateResidualSumOfSquares();
					double errorVariance = regression2.estimateErrorVariance();
					
					String resultStr = "回归曲线，截距:"+beta[0];
					
					for (int i = 1 ; i<beta.length;i++) {  
						resultStr+=",x"+i+"系数为:" + beta[i];  
					} 
					
					double[][] ha = {{beta[0]}};
					resultDf2.setData(ha);
					resultDf2.setMessage("这个是系数返回,"+resultStr);
					resultDf2.setFlag(true);
					
					double[] coefficients = new double[beta.length-1];
					
					for (int i = 1 ; i<beta.length;i++) {  
						coefficients[i-1] = beta[i];
					} 
					
					
					double[][] coefficients2 = {coefficients};
					
					
					resultDf.setData(coefficients2);
					resultDf.setMessage("这个是截距");
					
				} catch (MathIllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					resultDf.setMessage(e.getMessage());
					resultDf.setFlag(false);
					
				}
		        
		        resultDf.setMessage("运算成功");
		        resultDf.setFlag(true);
		        
		        DataFramePlus[] array = {resultDf2,resultDf};
		        
		        
				return array;  
	}




}
