/**  
* @Title: CommentServiceImpl.java 
* @author Administrator  
* @date 2019年6月19日  
* @version V1.0  
*/ 
package com.proven.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.proven.base.service.impl.BaseServiceImpl;
import com.proven.business.dao.CommentMapper;
import com.proven.business.model.Comment;
import com.proven.business.service.CommentService;

/**  
* @ClassName: CommentServiceImpl  
* @author Administrator  
* @date 2019年6月19日    
*/
@Service
@Transactional
public class CommentServiceImpl extends BaseServiceImpl<Comment> implements CommentService{

	@Autowired
	private CommentMapper commentMapper;
	/**
	* <p>Title: getComments</p>  
	* <p>Description: </p>  
	* @param commentId
	* @param page
	* @param row
	* @return  
	* @see com.proven.business.service.CommentService#getComments(int, int, int)  
	*/  
	@Override
	public PageInfo<Comment> getComments(int commentId, int page, int row) {
		PageHelper.startPage(page, row);
		List<Comment> comments = commentMapper.getComments(commentId);
		
		PageInfo<Comment> info = new PageInfo<>(comments);
		return info;
	}

}
