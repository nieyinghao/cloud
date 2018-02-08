package com.sinohealth.cloud.math.service;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.RealMatrix;

import com.sinohealth.cloud.math.service.interfaces.IMatrixService;
import com.sinohealth.cloud.vo.DataFrame;

public class MatrixService implements IMatrixService {

	public DataFrame inverse(double[][] datas) {
		// TODO Auto-generated method stub
		DataFrame df = new DataFrame();
		
		try {
			RealMatrix matrix = new Array2DRowRealMatrix(datas);
			RealMatrix result = new LUDecomposition(matrix).getSolver().getInverse();
			df.setDatas(result.getData());
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

	public DataFrame transpose(double[][] datas) {
			// TODO Auto-generated method stub
			DataFrame df = new DataFrame();
			
			
			try {
				RealMatrix matrix = new Array2DRowRealMatrix(datas);
				RealMatrix result = matrix.transpose();
	
				df.setDatas(result.getData());
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

	public DataFrame multiply(double[][] data1, double[][] data2) {
		// TODO Auto-generated method stub
		DataFrame df = new DataFrame();

		
		try {
			RealMatrix matrix1 = new Array2DRowRealMatrix(data1, true);	
			RealMatrix matrix2 = new Array2DRowRealMatrix(data2, true);		
			RealMatrix resultMatrix = matrix1.multiply(matrix2);
			df.setDatas(resultMatrix.getData());
		} catch (Exception e) {
			df.setMessage(e.getMessage());
			df.setFlag(false);
		}

		df.setMessage("运算成功");
		df.setFlag(true);

		return df;
	}
	
	
	public DataFrame add(double[][] data1, double[][] data2) {
		// TODO Auto-generated method stub
		DataFrame df = new DataFrame();

		try {
			RealMatrix matrix1 = new Array2DRowRealMatrix(data1, true);	
			RealMatrix matrix2 = new Array2DRowRealMatrix(data2, true);	
			
			RealMatrix resultMatrix = matrix1.add(matrix2);
			df.setDatas(resultMatrix.getData());
		} catch (Exception e) {
			df.setMessage(e.getMessage());
			df.setFlag(false);
		}

		df.setMessage("矩阵相加成功");
		df.setFlag(true);

		return df;
	}
	
	

}
