package com.sinohealth.cloud.math.service;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.springframework.stereotype.Service;

import com.sinohealth.cloud.math.service.interfaces.IMatrixService;
import com.sinohealth.cloud.vo.DataFrame;
import com.sinohealth.cloud.vo.DataFramePlus;

@Service
public class MatrixService implements IMatrixService {

	public DataFramePlus inverse(double[][] datas) {
		// TODO Auto-generated method stub
		DataFramePlus df = new DataFramePlus();
		
		try {
			RealMatrix matrix = new Array2DRowRealMatrix(datas);
			RealMatrix result = new LUDecomposition(matrix).getSolver().getInverse();
			df.setData(result.getData());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			df.setMessage(e.getMessage());
			df.setFlag(false);
			
		}

		df.setMessage("运算成功");
		df.setFlag(true);
		
		return df;
	}

	public DataFramePlus transpose(double[][] datas) {
			// TODO Auto-generated method stub
		DataFramePlus df = new DataFramePlus();
			
			
			try {
				RealMatrix matrix = new Array2DRowRealMatrix(datas);
				RealMatrix result = matrix.transpose();
	
				df.setData(result.getData());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				df.setMessage(e.getMessage());
				df.setFlag(false);
				
			}
	
			df.setMessage("运算成功");
			df.setFlag(true);
	
			
			return df;
	}

	public DataFramePlus multiply(double[][] data1, double[][] data2) {
		// TODO Auto-generated method stub
		DataFramePlus df = new DataFramePlus();

		
		try {
			RealMatrix matrix1 = new Array2DRowRealMatrix(data1, true);	
			RealMatrix matrix2 = new Array2DRowRealMatrix(data2, true);		
			RealMatrix resultMatrix = matrix1.multiply(matrix2);
			df.setData(resultMatrix.getData());
		} catch (Exception e) {
			df.setMessage(e.getMessage());
			df.setFlag(false);
		}

		df.setMessage("运算成功");
		df.setFlag(true);

		return df;
	}
	
	
	public DataFramePlus add(double[][] data1, double[][] data2) {
		// TODO Auto-generated method stub
		DataFramePlus df = new DataFramePlus();

		try {
			RealMatrix matrix1 = new Array2DRowRealMatrix(data1, true);	
			RealMatrix matrix2 = new Array2DRowRealMatrix(data2, true);	
			
			RealMatrix resultMatrix = matrix1.add(matrix2);
			df.setData(resultMatrix.getData());
		} catch (Exception e) {
			df.setMessage(e.getMessage());
			df.setFlag(false);
		}

		df.setMessage("矩阵相加成功");
		df.setFlag(true);

		return df;
	}

	public DataFramePlus binarization(DataFramePlus[] dps) {
		// TODO Auto-generated method stub
		DataFramePlus metaData = dps[0]; 
		DataFramePlus dp = dps[1];
		double[] thresholdVector =  dp.getData()[0];
		
		DataFramePlus resultDp = metaData.deepClone();
		
		
		double[][] data = metaData.getData();
		  
		double[][] resultData = new double [data.length][data[0].length]; 
		
		System.out.println(thresholdVector.length);
		
		System.out.println("yoxi:"+data.length);
	    for(int a = 0 ;a<data.length;a++){//获取行的长度  
	        for(int b = 0 ;b<data[a].length;b++){//获取列的长度  
	              if(data[a][b]>thresholdVector[b]){
	            	  System.out.println(data[a][b]+","+thresholdVector[b]);
	            	  resultData[a][b]=1;
	              }else {
//	            	  resultData[a][b] = 0;
	              }
	        }  
	    }  
		
		resultDp.setData(resultData);
		resultDp.setMessage("二值化成功");
		return resultDp;
	}
	
	

}
