package com.sinohealth.cloud.vo;

import java.io.Serializable;

public class BaseVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -554540599517371867L;
	private String cityn;
	private String period;
	
	public String getCityn() {
		return cityn;
	}
	public void setCityn(String cityn) {
		this.cityn = cityn;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	
}
