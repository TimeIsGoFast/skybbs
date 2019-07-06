/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.proven.system.service 
 * @author: Administrator   
 * @date: 2018年9月21日 下午10:20:44 
 */
package com.proven.system.service;

import com.github.pagehelper.PageInfo;
import com.proven.base.service.BaseService;
import com.proven.system.model.User;

/**   
* Copyright: Copyright (c) 2018 Weilong Zeng
* 
* @ClassName: UserService.java
* @Description: 
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年9月21日 下午10:20:44 
*
*/
public interface UserService extends BaseService<User>{

	User getUserByUid(String uid);

	void saveUserRoleMap(Integer id, int roleId);

	/**  
	 *@Description:
	 *-----------------------------------------------------
	 *Author			date				comments
	 *Zeng,Weilong		2019年7月6日				init method
	 *-----------------------------------------------------
	 * @return String 
	 */
	PageInfo<User> getUserData(int page, int row, String search);

}
