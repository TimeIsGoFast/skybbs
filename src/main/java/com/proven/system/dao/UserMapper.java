package com.proven.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.proven.system.model.User;
import tk.mybatis.mapper.common.Mapper;
/**
 * 
* @ClassName: UserMapper  
* @author Administrator  
* @date 2019年7月18日
 */
public interface UserMapper extends Mapper<User> {

	/**   
	* @Function: UserMapper.java
	* @Description:
	*
	* @param:
	* @return：
	* @throws：
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018年9月21日 下午10:42:18 
	*
	* History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2018年9月21日     Administrator           v1.0.0              
	*/
	User getUserByUid(@Param(value="uid")String uid);

	void saveUserRoleMap(@Param(value="userId")Integer userId, @Param(value="roleId")int roleId);

	/**  
	 *@Description:
	 *-----------------------------------------------------
	 *Author			date				comments
	 *Zeng,Weilong		2019年7月6日				init method
	 *-----------------------------------------------------
	 * @return List<User> 
	 */
	List<User> getUserData(@Param(value="search")String search);
}