package com.sinohealth.cloud.math.service.interfaces;

import com.sinohealth.cloud.vo.DataFrame;

public interface ILinearService {
	public DataFrame matrixMultiply(double[][] x,double[] y);
}
