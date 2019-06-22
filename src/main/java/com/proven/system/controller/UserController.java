/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.proven.system.controller 
 * @author: Administrator   
 * @date: 2018年9月21日 下午10:22:16 
 */
package com.proven.system.controller;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.proven.base.controller.BaseController;
import com.proven.base.vo.Result;
import com.proven.parambean.UserParam;
import com.proven.system.model.User;
import com.proven.system.service.UserService;

/**   
* Copyright: Copyright (c) 2018 Weilong Zeng
* 
* @ClassName: UserController.java
* @Description: 
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年9月21日 下午10:22:16 
*
*/
@Controller
@RequestMapping("/user")
public class UserController extends BaseController<User>{
	@Autowired
	private UserService userService;
	
    private static final Logger logger  = Logger.getLogger(UserController.class);
    
    /**
     * 
     *@Description:register function 
     *-----------------------------------------------------
     *Author			date				comments
     *Zeng,Weilong		2019年6月22日				init method
     *-----------------------------------------------------
     * @return int
     */
	@RequestMapping("/register")
	@ResponseBody
	public Result register(UserParam param){
		Result result = new Result("success",true);
		logger.info("username="+param.getEmail()+" ,fullname"+param.getNickName()+" ,telephone"+param.getTel()+" ,password"+param.getPassword());
		//judge user if exist in database
		User dbuser = userService.getUserByUid(param.getEmail());
		if(dbuser!=null){
			try {
				//register
				User user = new User();
				user.setMail(param.getEmail());
				user.setCreateBy(param.getEmail());
				user.setName(param.getNickName());
				user.setCreateDate(new Date());
				user.setEnabled("N");
				user.setPassword(param.getPassword());
				user.setTel(param.getTel());
				user.setUid(param.getEmail());
				//save user to user table
				userService.save(user);
				//save user_role map to user_role map,this is for permission,if did not do this operate, user will can't access any url
				User users = userService.getUserByUid(user.getUid());
				int roleId = 3;
				//userService.saveUserRoleMap(users.getId(),roleId);				
				//send email to active user account
				
				
			} catch (Exception e) {
				logger.error(e);
				result.setMsg("Runtime Exception"+e.getMessage());
				result.setSuccess(false);
				result.setErrorCode(200);
				return result;
			}
		
			
		}else{
			result.setMsg("该账号已经被注册");
			result.setSuccess(false);
			result.setErrorCode(100);
			return result;
		}
		return result;
	}
}
