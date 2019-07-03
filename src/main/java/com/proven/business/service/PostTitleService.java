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

	/**  
	 *@param name 
	 * @Description:
	 *-----------------------------------------------------
	 *Author			date				comments
	 *Zeng,Weilong		2019年6月29日				init method
	 *-----------------------------------------------------
	 * @return void 
	 */
	void updateName(String uid, String name);

	/**  
	 *@Description:
	 *-----------------------------------------------------
	 *Author			date				comments
	 *Zeng,Weilong		2019年6月30日				init method
	 *-----------------------------------------------------
	 * @return PageInfo<PostTitle> 
	 */
	PageInfo<PostTitle> getAdminTitleData(int page, int row, String search);



}
