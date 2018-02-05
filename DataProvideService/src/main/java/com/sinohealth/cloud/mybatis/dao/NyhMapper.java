package com.sinohealth.cloud.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sinohealth.cloud.vo.Nyh;



@Mapper
public interface NyhMapper {
	  //1
	    //根据age查找info
	    List<Nyh> getNyh(long id);


}
