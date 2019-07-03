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

	/**  
	 *@Description:
	 *-----------------------------------------------------
	 *Author			date				comments
	 *Zeng,Weilong		2019年6月29日				init method
	 *-----------------------------------------------------
	 * @return void 
	 */
	void updateName(@Param(value="uid")String uid,@Param(value="name")String name);

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