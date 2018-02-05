package com.sinohealth.cloud.vo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;

public class DataFrame implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1505993411130362981L;
	
	private double[][] datas;
	private double[] data;
	private double intercept;
	private double[] coefficients;
	private String message;
	private boolean flag;
	private Map<String,double[][]> map;
	
	
	


	public Map<String, double[][]> getMap() {
		return map;
	}

	public void setMap(Map<String, double[][]> map) {
		this.map = map;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public double[] getData() {
		return data;
	}

	public double getIntercept() {
		return intercept;
	}

	public void setIntercept(double intercept) {
		this.intercept = intercept;
	}

	public double[] getCoefficients() {
		return coefficients;
	}

	
	public String coefficientsToString() {
		return "DataFrame [coefficients=" + Arrays.toString(coefficients) + "]";
	}

	public void setCoefficients(double[] coefficients) {
		this.coefficients = coefficients;
	}

	public void setData(double[] data) {
		this.data = data;
	}

	public double[][] getDatas() {
		return datas;
	}

	public void setDatas(double[][] datas) {
		this.datas = datas;
	}
	
}
