package com.sinohealth.cloud.impl.math;

import org.apache.commons.math3.stat.inference.TestUtils;

public class StatisticsImpl implements com.sinohealth.cloud.interfaces.math.Statistics {
	
	
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
