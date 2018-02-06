package com.sinohealth.cloud.vo;

import java.io.Serializable;

public class Nyh implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 3623639159188007581L;
	private Long id;
    private String name;
    private String haha;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHaha() {
		return haha;
	}
	public void setHaha(String haha) {
		this.haha = haha;
	}

}
