package com.proven.business.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.proven.business.model.Reply;

import tk.mybatis.mapper.common.Mapper;

public interface ReplyMapper extends Mapper<Reply> {

	/**  
	 *@Description:
	 *-----------------------------------------------------
	 *Author			date				comments
	 *Zeng,Weilong		2019年6月21日				init method
	 *-----------------------------------------------------
	 * @return List<Reply> 
	 */
	List<Reply> getReplysByCommentIds(@Param("commentIds")List<Integer> commentIds);

	/**  
	 *@Description:
	 *-----------------------------------------------------
	 *Author			date				comments
	 *Zeng,Weilong		2019年6月29日				init method
	 *-----------------------------------------------------
	 * @return void 
	 */
	void updateToName(@Param("uid")String uid, @Param("name")String name);

	/**  
	 *@Description:
	 *-----------------------------------------------------
	 *Author			date				comments
	 *Zeng,Weilong		2019年6月29日				init method
	 *-----------------------------------------------------
	 * @return void 
	 */
	void updateFromName(@Param("uid")String uid, @Param("name")String name);

	/**  
	 *@Description:
	 *-----------------------------------------------------
	 *Author			date				comments
	 *Zeng,Weilong		2019年6月30日				init method
	 *-----------------------------------------------------
	 * @return void 
	 */
	void deleteByCommentId(@Param("Id")Integer id);
}