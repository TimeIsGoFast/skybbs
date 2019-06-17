/**
 * 
 */
package com.proven.system.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.proven.base.vo.Result;
import com.proven.business.model.Config;
import com.proven.business.model.Theme;
import com.proven.business.service.ConfigService;
import com.proven.business.service.ThemeService;
import com.proven.constans.Constans;
import com.proven.system.model.User;
import com.proven.system.service.UserService;
import com.proven.utils.SpringUtil;

/**
 * @author Lay
 *
 */
@Controller
public class SystemController {
	private static final Logger logger  = Logger.getLogger(SystemController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ConfigService configService;
	
	@Autowired
	private ThemeService themeService;

	@RequestMapping("/renderLogin")
	public String renderLogin(){
		return "login";
	}
	@RequestMapping("/register")
	public String register(){
		return "register";
	}
	
	@RequestMapping("/403")
	public String render403(){
		return "403";
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public Result login(UsernamePasswordToken token, HttpSession session,HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		Result result = new Result();
		try {
			Subject subject = SecurityUtils.getSubject();
			subject.login(token);
			subject.getSession().setAttribute("USER", (String)subject.getPrincipal());
			result.setSuccess(true);
		} catch (UnknownAccountException e) {
			result.setSuccess(false);
			result.setMsg("帐号不存在");
		}catch(LockedAccountException e){
			result.setSuccess(false);
			result.setMsg("帐号被锁定");
		}catch(AuthenticationException e){
			result.setSuccess(false);
			result.setMsg("帐号密码错误");
		}
		return result;
	}
	
	@RequestMapping("/logout")
	public String logout(){
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "/login";
	}
	
	/**
	 * 
	* @Title: get index page 
	* @Description: 
	* @return String 
	* @throws
	* Author:Zeng,weilong
	* @date 2019年6月15日
	 */
	@RequestMapping("/index")
	public String index(Model model){
		logger.info("start go to index page!");
		String uid = (String)SecurityUtils.getSubject().getPrincipal();
		logger.info("uid=" +uid);
		if(!StringUtils.isEmpty(uid)){
			User user = userService.getUserByUid(uid);
			SpringUtil.setSession(Constans.CURRENT_USER, user);
			model.addAttribute("user",user);
		}
		List<Config> configList = configService.getConfigListByTypeId(1);
		List<Theme> themeList = themeService.selectAll();
		model.addAttribute("postTypes", configList);
		model.addAttribute("themes", themeList);
		return "index";
	
	}
}
