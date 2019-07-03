/**  
* @Title: ConfigServiceImpl.java 
* @author Administrator  
* @date 2019年6月15日  
* @version V1.0  
*/ 
package com.proven.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proven.base.service.impl.BaseServiceImpl;
import com.proven.business.dao.ConfigMapper;
import com.proven.business.model.Config;
import com.proven.business.service.ConfigService;

/**  
* @ClassName: ConfigServiceImpl  
* @author Administrator  
* @date 2019年6月15日    
*/
@Service
@Transactional
public class ConfigServiceImpl extends BaseServiceImpl<Config> implements ConfigService{
	
	@Autowired
	private ConfigMapper configMapper;
	/**
	* <p>Title: getConfigListByTypeId</p>  
	* <p>Description: </p>  
	* @param i
	* @return  
	* @see com.proven.business.service.ConfigService#getConfigListByTypeId(int)  
	*/  
	@Override
	public List<Config> getConfigListByGroupId(int groupId) {
		return configMapper.getConfigListByTypeId(groupId);
	}

}
