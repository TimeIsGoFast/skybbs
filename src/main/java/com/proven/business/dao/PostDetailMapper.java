package com.proven.business.dao;

import org.apache.ibatis.annotations.Param;

import com.proven.business.model.PostDetail;

import tk.mybatis.mapper.common.Mapper;

public interface PostDetailMapper extends Mapper<PostDetail> {

	/**  
	* @Title: selectByPostId  
	* @Description: 
	* @return PostDetail 
	* @throws
	* Author:Zeng,weilong
	* @date 2019年6月18日
	*/
	PostDetail selectByPostId(@Param(value="postId")int postId);
}