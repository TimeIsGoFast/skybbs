package com.proven.business.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.proven.business.model.PostTitle;

import tk.mybatis.mapper.common.Mapper;

public interface PostTitleMapper extends Mapper<PostTitle> {

	/**  
	* @Title: getPostTitleData  
	* @Description: 
	* @return List<PostTitle> 
	* @throws
	* Author:Zeng,weilong
	* @date 2019年6月15日
	*/
	List<PostTitle> getPostTitleData(@Param(value="typeId")int typeId, @Param(value="themeId")int themeId);

	/**  
	* @Title: insertReturnId  
	* @Description: 
	* @return int 
	* @throws
	* Author:Zeng,weilong
	* @date 2019年6月16日
	*/
	int insertReturnId(PostTitle postTitle);
}