package com.sinohealth.cloud.mybatis.dao;

import java.util.List;

import com.sinohealth.cloud.vo.ZzY2;

@Mapper
public interface ZzY2Mapper {
	public List<ZzY2> getTemperatureSample(String cityn,String period);
	
}
