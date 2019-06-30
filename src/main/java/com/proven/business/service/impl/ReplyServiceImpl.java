/**  
* @Title: ReplyServiceImpl.java 
* @author Administrator  
* @date 2019年6月21日  
* @version V1.0  
*/ 
package com.proven.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proven.base.service.impl.BaseServiceImpl;
import com.proven.business.dao.ReplyMapper;
import com.proven.business.model.Reply;
import com.proven.business.service.ReplyService;

/**  
* @ClassName: ReplyServiceImpl  
* @author Administrator  
* @date 2019年6月21日    
*/
@Service
@Transactional
public class ReplyServiceImpl extends BaseServiceImpl<Reply> implements ReplyService{
	
	@Autowired
	private ReplyMapper replyMapper;

	/**
	* <p>Title: updateName</p>  
	* <p>Description: </p>   
	*/  
	@Override
	public void updateName(String uid, String name) {
		replyMapper.updateToName(uid,name);
		replyMapper.updateFromName(uid,name);
		
	}

	/**
	* <p>Title: deleteByCommentId</p>  
	* <p>Description: </p>   
	*/  
	@Override
	public void deleteByCommentId(int commentId) {
		replyMapper.deleteByCommentId(commentId);
		
	}

}
