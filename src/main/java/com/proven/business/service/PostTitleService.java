/**  
* @Title: PostTitleService.java 
* @author Administrator  
* @date 2019年6月15日  
* @version V1.0  
*/ 
package com.proven.business.service;

import com.github.pagehelper.PageInfo;
import com.proven.base.service.BaseService;
import com.proven.business.model.PostTitle;

/**  
* @ClassName: PostTitleService  
* @author Administrator  
* @date 2019年6月15日    
*/
public interface PostTitleService extends BaseService<PostTitle>{

	/**  
	* @param row 
	 * @param page 
	 * @Title: getPostTitleData  
	* @Description: 
	* @return List<PostTitle> 
	* @throws
	* Author:Zeng,weilong
	* @date 2019年6月15日
	*/
	PageInfo<PostTitle> getPostTitleData(String typeId, String themeId, int page, int row);

	/**  
	* @Title: insert  
	* @Description: 
	* @return int 
	* @throws
	* Author:Zeng,weilong
	* @date 2019年6月16日
	*/
	int insert(PostTitle postTitle);

}
