/**  
* @Title: CommentService.java 
* @author Administrator  
* @date 2019年6月19日  
* @version V1.0  
*/ 
package com.proven.business.service;

import com.github.pagehelper.PageInfo;
import com.proven.base.service.BaseService;
import com.proven.business.model.Comment;

/**  
* @ClassName: CommentService  
* @author Administrator  
* @date 2019年6月19日    
*/
public interface CommentService extends BaseService<Comment>{

	/**  
	* @Title: getComments  
	* @Description: 
	* @return PageInfo<Comment> 
	* @throws
	* Author:Zeng,weilong
	* @date 2019年6月19日
	*/
	PageInfo<Comment> getComments(int commentId, int page, int row);

}
