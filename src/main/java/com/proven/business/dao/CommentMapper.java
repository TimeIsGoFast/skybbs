package com.proven.business.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.proven.business.model.Comment;

import tk.mybatis.mapper.common.Mapper;

public interface CommentMapper extends Mapper<Comment> {

	/**  
	* @Title: getComments  
	* @Description: 
	* @return List<Comment> 
	* @throws
	* Author:Zeng,weilong
	* @date 2019年6月19日
	*/
	List<Comment> getComments(@Param(value="titleId")int titleId);
}