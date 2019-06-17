/**  
* @Title: ThemeService.java 
* @author Administrator  
* @date 2019年6月13日  
* @version V1.0  
*/ 
package com.proven.business.service;

import java.util.List;

import com.proven.base.service.BaseService;
import com.proven.business.model.Theme;

/**  
* @ClassName: ThemeService  
* @author Administrator  
* @date 2019年6月13日    
*/
public interface ThemeService extends BaseService<Theme>{

	/**  
	* @Title: getThemeData  
	* @Description: 
	* @return List<Theme> 
	* @throws
	* Author:Zeng,weilong
	* @date 2019年6月13日
	*/
	List<Theme> getThemeData();

}
