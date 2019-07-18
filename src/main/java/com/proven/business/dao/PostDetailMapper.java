package com.proven.business.dao;

import org.apache.ibatis.annotations.Param;

import com.proven.business.model.PostDetail;

import tk.mybatis.mapper.common.Mapper;
/**
 * 
* @ClassName: PostDetailMapper  
* @author Administrator  
* @date 2019年7月18日
 */
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

	/**  
	 *@Description:
	 *-----------------------------------------------------
	 *Author			date				comments
	 *Zeng,Weilong		2019年6月29日				init method
	 *-----------------------------------------------------
	 * @return void 
	 */
	void updateName(@Param(value="uid")String uid, @Param(value="name")String name);

	/**  
	 *@Description:
	 *-----------------------------------------------------
	 *Author			date				comments
	 *Zeng,Weilong		2019年6月30日				init method
	 *-----------------------------------------------------
	 * @return void 
	 */
	void deleteBytitleId(@Param(value="titleId")int titleId);
}