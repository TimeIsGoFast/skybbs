/**  
* @Title: CommentService.java 
* @author Administrator  
* @date 2019年6月19日  
* @version V1.0  
*/ 
package com.proven.business.service;

import com.github.pagehelper.PageInfo;
import com.proven.base.service.BaseService;
import com.proven.business.dtos.CommentDto;
import com.proven.business.model.Comment;
import com.proven.business.model.PostTitle;

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
	PageInfo<CommentDto> getComments(int commentId, int page, int row);

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
	void deleteByTitleId(int titleId);

	/**  
	 *@Description:
	 *-----------------------------------------------------
	 *Author			date				comments
	 *Zeng,Weilong		2019年6月30日				init method
	 *-----------------------------------------------------
	 * @return PageInfo<PostTitle> 
	 */
	PageInfo<PostTitle> getAdminCommentData(int page, int row, String search);

}
