package com.sinohealth.cloud.interfaces.RemoteData;

import java.util.List;

import com.sinohealth.cloud.vo.ZzY2;

public interface TemperatureData {
	public List<ZzY2> getByCityAndPeriod(String cityn,String period);
}
