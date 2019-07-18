package com.proven.business.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.proven.business.model.Config;

import tk.mybatis.mapper.common.Mapper;
/**
 * 
* @ClassName: ConfigMapper  
* @author Administrator  
* @date 2019年7月18日
 */
public interface ConfigMapper extends Mapper<Config> {

	/**  
	* @Title: getConfigListByTypeId  
	* @Description: 
	* @return List<Config> 
	* @throws
	* Author:Zeng,weilong
	* @date 2019年6月15日
	*/
	List<Config> getConfigListByTypeId(@Param(value="groupId")int groupId);
}