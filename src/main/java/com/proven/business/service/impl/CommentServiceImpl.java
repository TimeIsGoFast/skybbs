/**  
* @Title: CommentServiceImpl.java 
* @author Administrator  
* @date 2019年6月19日  
* @version V1.0  
*/ 
package com.proven.business.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.proven.base.service.impl.BaseServiceImpl;
import com.proven.business.dao.CommentMapper;
import com.proven.business.dao.ReplyMapper;
import com.proven.business.dtos.CommentDto;
import com.proven.business.model.Comment;
import com.proven.business.model.CommentVo;
import com.proven.business.model.PostTitle;
import com.proven.business.model.Reply;
import com.proven.business.service.CommentService;

/**  
* @ClassName: CommentServiceImpl  
* @author Administrator  
* @date 2019年6月19日    
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class CommentServiceImpl extends BaseServiceImpl<Comment> implements CommentService{

	@Autowired
	private CommentMapper commentMapper;
	
	@Autowired
	private ReplyMapper replyMapper;
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
	public PageInfo<CommentDto> getComments(int titleId, int page, int row) {

		//start page
		PageHelper.startPage(page, row);
		List<CommentVo> comments = commentMapper.getComments(titleId);
		
		//get comments id to get all of the reply bean
		List<Integer> commentIds = comments.stream().map(CommentVo::getId).collect(Collectors.toList());
		List<Reply> replys = new ArrayList<>();
		if(!commentIds.isEmpty()){
			replys = replyMapper.getReplysByCommentIds(commentIds);
		}
		//List<Reply> replys = replyMapper.getReplysByCommentIds(commentIds);
		List<CommentDto> commentDtos = new ArrayList<>();
		//get commentsDaos that include comment and reply
		for(CommentVo com : comments){			
			CommentDto comDto = new CommentDto();
			comDto.setComment(com);
			List<Reply> res = replys.stream().filter(reply->reply.getCommentId().equals(com.getId())).collect(Collectors.toList());
			if(res.isEmpty()){
				res = new ArrayList<>();
			}
			comDto.setReplys(res);
			commentDtos.add(comDto);
		}
		
		PageInfo<CommentDto> info = new PageInfo<>(commentDtos);
		return info;
	}
	/**
	* <p>Title: updateName</p>  
	* <p>Description: </p>   
	*/  
	@Override
	public void updateName(String uid, String name) {
		commentMapper.updateName(uid,name);
		
	}
	/**
	* <p>Title: deleteByTitleId</p>  
	* <p>Description: </p>   
	*/  
	@Override
	public void deleteByTitleId(int titleId) {
		List<CommentVo> comments = commentMapper.getComments(titleId);
		for (CommentVo commentVo : comments) {
			replyMapper.deleteByCommentId(commentVo.getId());
		}
		commentMapper.deleteByTitleId(titleId);
	}
	/**
	* <p>Title: getAdminCommentData</p>  
	* <p>Description: </p>   
	*/  
	@Override
	public PageInfo<PostTitle> getAdminCommentData(int page, int row, String search) {
		PageHelper.startPage(page, row);
		List<PostTitle> list = commentMapper.getAdminTitleData(search);
		PageInfo<PostTitle> info = new PageInfo<>(list);
		return info;
	}

}
