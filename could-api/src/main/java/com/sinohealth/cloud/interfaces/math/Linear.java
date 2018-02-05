package com.sinohealth.cloud.interfaces.math;

import com.sinohealth.cloud.vo.DataFrame;

public interface Linear {
	public DataFrame matrixMultiply(double[][] x,double[] y);
}
