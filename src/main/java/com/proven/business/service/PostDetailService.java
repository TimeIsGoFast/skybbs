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

}
