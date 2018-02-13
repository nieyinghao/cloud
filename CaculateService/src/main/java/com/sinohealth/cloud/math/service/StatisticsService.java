package com.sinohealth.cloud.math.service;

import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.descriptive.moment.Variance;
import org.apache.commons.math3.stat.inference.TestUtils;

import com.sinohealth.cloud.math.service.interfaces.IStatisticsService;
import com.sinohealth.cloud.vo.DataFramePlus;

public class StatisticsService implements IStatisticsService {
	
	
	public String TExamine(double[] sample, double mu, boolean flag) {
		// TODO Auto-generated method stub
		

		double TValue = TestUtils.t(mu, sample);
		
//		TestUtils.
		
		
		return null;
	}

	/**
	 * 通过DataFramePlus数据计算每一列的方差
	 * @param df 数据
	 * @return 每一列的方差
	 */
	public double[] variance(DataFramePlus df) {
		if (df != null) {
			int colNum = df.getDimensions()[1];
			double[] result = new double[colNum];
			for (int i = 0; i < colNum; i++) {
				double[] col = df.getColumn(0);
				result[i] = variance(col);
			}
			return result;
		}
		return null;
	}

	/**
	 * 根据double类型数组求该数据方差
	 * @param d 数据
	 * @return
	 */
	public double variance(double[] d) {
		if (d != null && d.length != 0) {
			return StatUtils.variance(d);
		}
		return 0;
	}
	
	public static void main(String[] args) {
		double[] observed = {1d,1d, 3d, 5d,5d};
		double mu = 1d;
		System.out.println(TestUtils.t(mu, observed));
	}

	
	
}
