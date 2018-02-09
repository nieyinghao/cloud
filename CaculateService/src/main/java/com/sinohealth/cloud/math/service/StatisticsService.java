package com.sinohealth.cloud.math.service;

import org.apache.commons.math3.stat.inference.TestUtils;

import com.sinohealth.cloud.math.service.interfaces.IStatisticsService;

public class StatisticsService implements IStatisticsService {
	
	
	public String TExamine(double[] sample, double mu, boolean flag) {
		// TODO Auto-generated method stub
		

		double TValue = TestUtils.t(mu, sample);
		
//		TestUtils.
		
		
		return null;
	}

	public static void main(String[] args) {
		double[] observed = {1d,1d, 3d, 5d,5d};
		double mu = 1d;
		System.out.println(TestUtils.t(mu, observed));
	}
	
}
