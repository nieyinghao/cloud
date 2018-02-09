package com.sinohealth.cloud.math.service.interfaces;

import com.sinohealth.cloud.vo.DataFrame;
import com.sinohealth.cloud.vo.DataFramePlus;

public interface ILinearService {
	public DataFramePlus[] matrixMultiply(double[][] x,double[] y);
}
