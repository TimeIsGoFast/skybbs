/**  
* @Title: ReplyService.java 
* @author Administrator  
* @date 2019年6月21日  
* @version V1.0  
*/ 
package com.proven.business.service;

import com.proven.base.service.BaseService;
import com.proven.business.model.Reply;

/**  
* @ClassName: ReplyService  
* @author Administrator  
* @date 2019年6月21日    
*/
public interface ReplyService extends BaseService<Reply>{

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
	void deleteByCommentId(int commentId);

}
