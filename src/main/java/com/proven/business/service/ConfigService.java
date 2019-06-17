/**  
* @Title: ConfigService.java 
* @author Administrator  
* @date 2019年6月15日  
* @version V1.0  
*/ 
package com.proven.business.service;

import java.util.List;

import com.proven.base.service.BaseService;
import com.proven.business.model.Config;

/**  
* @ClassName: ConfigService  
* @author Administrator  
* @date 2019年6月15日    
*/
public interface ConfigService extends BaseService<Config>{

	/**  
	* @Title: getConfigListByTypeId  
	* @Description: 
	* @return List<Config> 
	* @throws
	* Author:Zeng,weilong
	* @date 2019年6月15日
	*/
	List<Config> getConfigListByTypeId(int i);

}
