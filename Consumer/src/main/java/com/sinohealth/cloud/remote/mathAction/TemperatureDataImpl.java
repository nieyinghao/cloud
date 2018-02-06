package com.sinohealth.cloud.remote.mathAction;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.sinohealth.cloud.interfaces.RemoteData.TemperatureData;
import com.sinohealth.cloud.vo.BaseVo;
import com.sinohealth.cloud.vo.ZzY2;

public class TemperatureDataImpl implements  TemperatureData {


	public List<ZzY2> getByCityAndPeriod(String cityn, String period) {
		String url = "http://localhost:8082/ZzY2";
	    //入参
	    RestTemplate restTemplate = new RestTemplate();
	    BaseVo vo = new BaseVo();
	    vo.setCityn(cityn);
	    vo.setPeriod(period);
	    ZzY2[] haha =  restTemplate.postForObject(url, vo, ZzY2[].class);
	    
	    List<ZzY2> result = Arrays.asList(haha);
		return result;
	}

}
