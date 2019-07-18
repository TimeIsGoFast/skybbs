/**  
* @Title: ThemeServiceImpl.java 
* @author Administrator  
* @date 2019年6月13日  
* @version V1.0  
*/ 
package com.proven.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proven.base.service.impl.BaseServiceImpl;
import com.proven.business.dao.ThemeMapper;
import com.proven.business.model.Theme;
import com.proven.business.service.ThemeService;

/**  
* @ClassName: ThemeServiceImpl  
* @author Administrator  
* @date 2019年6月13日    
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class ThemeServiceImpl extends BaseServiceImpl<Theme> implements ThemeService{
	@Autowired
	private ThemeMapper themeMapper;
	/**
	* <p>Title: getThemeData</p>  
	* <p>Description: </p>  
	* @return  
	* @see com.proven.business.service.ThemeService#getThemeData()  
	*/  
	@Override
	public List<Theme> getThemeData() {
		return null;
	}

}
