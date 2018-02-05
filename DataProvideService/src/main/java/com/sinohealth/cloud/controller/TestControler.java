package com.sinohealth.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sinohealth.cloud.mybatis.dao.NyhMapper;
import com.sinohealth.cloud.mybatis.dao.ZzY2Mapper;
import com.sinohealth.cloud.vo.BaseVo;
import com.sinohealth.cloud.vo.Nyh;
import com.sinohealth.cloud.vo.ZzY2;



@RestController
public class TestControler {

	@Autowired NyhMapper nyhDao;
	@Autowired ZzY2Mapper zzY2Mapper;
	
	
	@RequestMapping(value = "/nyh", method = RequestMethod.POST)
	public Nyh nyh(@RequestBody String id){
		
		System.out.println(id);
		List<Nyh>  result = nyhDao.getNyh(Long.parseLong(id));
		
		System.out.println(result.get(0));
		return result.get(0);
		
	}
	
	
	
	@RequestMapping(value = "/ZzY2", method = RequestMethod.POST)
	public List<ZzY2> getZzY2(@RequestBody BaseVo vo){
		
		System.out.println(vo.getCityn());
		return zzY2Mapper.getTemperatureSample(vo.getCityn(), vo.getPeriod());
		
	}
	
	
	
	
	
	
	
	
}
