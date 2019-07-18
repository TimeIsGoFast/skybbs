package com.proven.business.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.proven.business.model.Comment;
import com.proven.business.model.CommentVo;
import com.proven.business.model.PostTitle;

import tk.mybatis.mapper.common.Mapper;
/**
 * 
* @ClassName: CommentMapper  
* @author Administrator  
* @date 2019年7月18日
 */
public interface CommentMapper extends Mapper<Comment> {

	/**  
	* @Title: getComments  
	* @Description: 
	* @return List<Comment> 
	* @throws
	* Author:Zeng,weilong
	* @date 2019年6月19日
	*/
	List<CommentVo> getComments(@Param(value="titleId")int titleId);

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
	void deleteByTitleId(@Param(value="titleId")int titleId);

	/**  
	 *@Description:
	 *-----------------------------------------------------
	 *Author			date				comments
	 *Zeng,Weilong		2019年6月30日				init method
	 *-----------------------------------------------------
	 * @return List<PostTitle> 
	 */
	List<PostTitle> getAdminTitleData(@Param(value="search")String search);
}