/**  
* @Description: 
* @author Administrator  
* @date 2019年6月21日  
* @version V1.0  
*/ 
package com.proven.business.dtos;

import java.util.List;

import com.proven.business.model.Comment;
import com.proven.business.model.Reply;

/**  
* @ClassName: CommentDto  
* @author Administrator  
* @date 2019年6月21日    
*/
public class CommentDto{

	private Comment comment;
	private List<Reply> replys;
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public List<Reply> getReplys() {
		return replys;
	}
	public void setReplys(List<Reply> replys) {
		this.replys = replys;
	}
	
	
}
