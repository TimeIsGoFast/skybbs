/**  
* @Title: PostDetailService.java 
* @author Administrator  
* @date 2019年6月16日  
* @version V1.0  
*/ 
package com.proven.business.service;

import com.proven.base.service.BaseService;
import com.proven.business.model.PostDetail;

/**  
* @ClassName: PostDetailService  
* @author Administrator  
* @date 2019年6月16日    
*/
public interface PostDetailService extends BaseService<PostDetail>{

	/**  
	* @Title: selectByPostId  
	* @Description: 
	* @return PostDetail 
	* @throws
	* Author:Zeng,weilong
	* @date 2019年6月18日
	*/
	PostDetail selectByPostId(int postId);

	/**  
	 *@Description:
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
	 * @return void 
	 */
	void deleteBytitleId(int titleId);

}
