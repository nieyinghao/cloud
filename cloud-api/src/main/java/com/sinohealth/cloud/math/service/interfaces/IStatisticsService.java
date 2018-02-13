package com.sinohealth.cloud.math.service.interfaces;

import com.sinohealth.cloud.vo.DataFramePlus;

public interface IStatisticsService {
	/**
	 * t检验
	 * @param sample
	 * @param mu
	 * @param flag
	 * @return
	 */
	public String TExamine(double[] sample, double mu, boolean flag);
	
	/**
	 * 通过DataFramePlus数据计算每一列的方差
	 * @param df 数据
	 * @return 每一列的方差
	 */
	public double[] variance(DataFramePlus df);
	
	/**
	 * 根据double类型数组求该数据方差
	 * @param d 数据
	 * @return
	 */
	public double variance(double[] d);
	
	
}
