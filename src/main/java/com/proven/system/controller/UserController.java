/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.proven.system.controller 
 * @author: Administrator   
 * @date: 2018年9月21日 下午10:22:16 
 */
package com.proven.system.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.proven.base.controller.BaseController;
import com.proven.base.vo.FileVo;
import com.proven.base.vo.Result;
import com.proven.business.service.CommentService;
import com.proven.business.service.PostDetailService;
import com.proven.business.service.PostTitleService;
import com.proven.business.service.ReplyService;
import com.proven.constans.Constans;
import com.proven.parambean.UserParam;
import com.proven.system.model.User;
import com.proven.system.service.UserService;
import com.proven.utils.CommonUtil;
import com.proven.utils.DateFormatUtil;
import com.proven.utils.FileUtils;
import com.proven.utils.MailUtil;
import com.proven.utils.PropertyUtil;

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
	
	
    private static final Logger logger  = Logger.getLogger(UserController.class);
    @Autowired
	private UserService userService;
    
    @Autowired
	private PostTitleService titleService;
    
    @Autowired
    private PostDetailService deatilService;
    
    @Autowired
    private CommentService commentService;
    
    @Autowired
    private ReplyService replyService;
    
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
	public Result register(UserParam param,String verifyCode,HttpSession session){
		Result result = new Result("success",true);
		logger.info("uid="+param.getUid()+"email="+param.getEmail()+" ,fullname"+param.getNickName()+" ,telephone"+param.getTel()+" ,password"+param.getPassword());
		//judge user if exist in database
		User dbuser = userService.getUserByUid(param.getUid());
		
		String code  = session.getAttribute("strCode").toString();
		logger.info("code in behind is "+code+", code in front is "+ verifyCode);
		if(!verifyCode.equals(code)){
			result.setMsg("验证码不正确！");
			result.setSuccess(false);
			result.setErrorCode(200);
			return result;
		}
		
		if(dbuser==null){
			try {
				//register
				User user = new User();
				user.setMail(param.getEmail());
				user.setCreateBy(param.getUid());
				user.setName(param.getNickName());
				user.setCreateDate(new Date());
				user.setEnabled("N");
				user.setPassword(param.getPassword());
				user.setTel(param.getTel());
				user.setUid(param.getUid());
				user.setLogoUrl(PropertyUtil.getProperty("default.logo"));
				user.setRemark("user");
				//save user to user table
				userService.save(user);
				//save user_role map to user_role map,this is for permission,if did not do this operate, user will can't access any url
				User users = userService.getUserByUid(user.getUid());
				int roleId = 3;
				userService.saveUserRoleMap(users.getId(),roleId);				
				//send email to active user account
				String[] connect = enrichConnect(users.getId());
				MailUtil.sendEmail(PropertyUtil.getProperty("mail.from.user"), users.getMail(), connect);
				
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

	/**
	 * 
	 *@Description:
	 *-----------------------------------------------------
	 *Author			date				comments
	 *Zeng,Weilong		2019年6月27日				init method
	 *-----------------------------------------------------
	 * @return String[]
	 */
	public String[] enrichConnect(int userId) {
		String[] connent = new String[10] ;
		String info = "激活:<a href=\""+PropertyUtil.getProperty("app.url")+userId+"\">点击激活账户</a>";
        info = info + "<br/>如果激活未成功，请把地址复制到浏览器进行手动请求以进行激活:"+PropertyUtil.getProperty("app.url")+userId;
        logger.info("email info = "+info);
		connent[0]=PropertyUtil.getProperty("mail.title");
		connent[1]=info;
		connent[2]=PropertyUtil.getProperty("mail.qq");
		connent[3]=PropertyUtil.getProperty("mail.security.code");
		return connent;
	}
	
	public String[] enrichEmailInfo(String info){
		String[] connent = new String[10] ;
        logger.info("email info = "+info);
		connent[0]=PropertyUtil.getProperty("mail.title");
		connent[1]=info;
		connent[2]=PropertyUtil.getProperty("mail.qq");
		connent[3]=PropertyUtil.getProperty("mail.security.code");
		return connent;
	}
	
	/**
	 * 
	 *@Description:
	 *-----------------------------------------------------
	 *Author			date				comments
	 *Zeng,Weilong		2019年6月25日			enable user function
	 *-----------------------------------------------------
	 * @return String
	 */
	@RequestMapping("/enableUser")
	public String enableUser(int userId,Model model){
		User user = userService.selectByKey(userId);
		user.setEnabled("Y");
		userService.update(user);
		model.addAttribute("user", user);
		String message = PropertyUtil.getProperty("access.success");
		model.addAttribute("message", message);
		return "message";
		
	}
	
	/**
	 * 
	 *@Description:
	 *-----------------------------------------------------
	 *Author			date				comments
	 *Zeng,Weilong		2019年6月27日			go to update user info page
	 *-----------------------------------------------------
	 * @return String
	 */
	@RequestMapping("/updateInfo")
	public String updateInfo(int userId,Model model){
		User user = userService.selectByKey(userId);
		model.addAttribute("user", user);
		if(!StringUtils.isEmpty(user.getBirth())){
			String birth = DateFormatUtil.toDateoString(user.getBirth());
			model.addAttribute("birth", birth);
		}
		
		return "user/updateUserInfo";
	}
	
	/**
	 * 
	 *@Description:
	 *-----------------------------------------------------
	 *Author			date				comments
	 *Zeng,Weilong		2019年6月29日			update user info
	 *-----------------------------------------------------
	 * @return String
	 */
	@RequestMapping("/updateUser")
	public String updateUser(UserParam user,@RequestParam MultipartFile imgfile,HttpServletRequest request,Model model){
		
		User newUser = userService.selectByKey(user.getId());
		String path = PropertyUtil.getProperty("upload.image.path")+"user"+File.separator;
       	FileVo fileVo= FileUtils.uploadFile(imgfile, path);
       	//enrich newUser  	
       	try {
			newUser.setBirth(DateFormatUtil.parseDate(user.getBirth()));
		} catch (ParseException e) {
			logger.info(e);
		}
       	newUser.setCompany(user.getCompany());
       	newUser.setId(user.getId());
       	newUser.setTel(user.getTel());
       	//if filepath is empty,then save null to ligoUrl
       	if(!StringUtils.isEmpty(fileVo.getFilePath())){
       		newUser.setLogoUrl(PropertyUtil.getProperty("app.image.url")+File.separator+"user"+fileVo.getFilePath());
       	} 	
       	
       	//if new user name is same with old name,then update title and detail
       	logger.info("strat update other infomation");
       	if(!newUser.getName().equals(user.getName())){
       		titleService.updateName(newUser.getUid(),user.getName());
       	    deatilService.updateName(newUser.getUid(),user.getName());
       	    commentService.updateName(newUser.getUid(),user.getName());
       	    replyService.updateName(newUser.getUid(),user.getName());
       	    
       	}
       	newUser.setName(user.getName());
       	String message="";
		int info = userService.update(newUser);
		if(info==1){
		   message = "完善个人信息成功！";	
			
		}else if(info==0){
			message="完善个人信息失败";
		
		}else{
			message="出现未知错误";
			
		}
		model.addAttribute("user", newUser);
		model.addAttribute("message", message);
		return "message2";
	}

	
	/**
	 * 
	 *@Description:
	 *-----------------------------------------------------
	 *Author			date				comments
	 *Zeng,Weilong		2019年7月2日			get back password page
	 *-----------------------------------------------------
	 * @return String
	 */
	@RequestMapping("/getBackPwdPage")
	public String getBackPwdPage(){
		return "user/passwordBack";
	}
	
	/**
	 * 
	 *@Description:
	 *-----------------------------------------------------
	 *Author			date				comments
	 *Zeng,Weilong		2019年7月2日			get reset password page
	 *-----------------------------------------------------
	 * @return String
	 */
	@RequestMapping("/resetPwdPage")
	public String resetPwdPage(){
		return "user/restPwd";
	}
	
	/**
	 * 
	 *@Description:
	 *-----------------------------------------------------
	 *Author			date				comments
	 *Zeng,Weilong		2019年7月3日			resetPwd
	 *-----------------------------------------------------
	 * @return String
	 */
	@RequestMapping("/resetPwd")
	@ResponseBody
	public Result resetPwd(String uid,String oldPwd,String newPwd){
		Result result = new Result("success",true);
		
		try {
			User user = userService.getUserByUid(uid);
			
			if(user==null){
				result.setMsg("该账户不存在");
				result.setSuccess(false);
				return result;
			}
			
			if(!user.getPassword().equals(oldPwd)){
				result.setMsg("用户名原密码错误");
				result.setSuccess(false);
				return result;
			}
			
			user.setPassword(newPwd);
			
			userService.update(user);
			
			
		} catch (Exception e) {
			logger.error(e);
			result.setMsg("failed");
			result.setSuccess(false);
		}
		
		return result;
	}
	
	/**
	 * 
	 *@Description:
	 *-----------------------------------------------------
	 *Author			date				comments
	 *Zeng,Weilong		2019年7月3日			send verifyCode
	 *-----------------------------------------------------
	 * @return Result
	 */
	@RequestMapping("/sendVerifyCode")
	@ResponseBody
	public Result sendVerifyCode(String uid){
		Result result = new Result("success",true);
		
		try {
			User user = userService.getUserByUid(uid);
			
			if(user==null){
				result.setMsg("该账户不存在");
				result.setSuccess(false);
				return result;
			}
			
			String code = CommonUtil.getVerifyCode(4);
			user.setSalt(code);
			userService.update(user);
			
			String info = "尊敬的用户，你的验证码为： "+code;
			String[] connect = enrichEmailInfo(info);
			MailUtil.sendEmail(PropertyUtil.getProperty("mail.from.user"), user.getMail(), connect);
			
		} catch (Exception e) {
			logger.error(e);
			result.setMsg("failed");
			result.setSuccess(false);
		}
		
		return result;
	}
	
	/**
	 * 
	 *@Description:
	 *-----------------------------------------------------
	 *Author			date				comments
	 *Zeng,Weilong		2019年7月3日			changeUserPwd
	 *-----------------------------------------------------
	 * @return Result
	 */
	@RequestMapping("/changeUserPwd")
	@ResponseBody
	public Result changeUserPwd(String uid,String code){
		Result result = new Result("success",true);
		
		try {
			User user = userService.getUserByUid(uid);
			if(user==null){
				result.setMsg("该账户不存在");
				result.setSuccess(false);
				return result;
			}
			
			if(!code.equals(user.getSalt())){
				result.setMsg("验证码不正确");
				result.setSuccess(false);
				return result;
			}
			
			String newPwd = CommonUtil.getRandomPwd(6);
			user.setPassword(newPwd);
			userService.update(user);
			
			String info = "尊敬的用户，你重置之后的密码为： "+newPwd+" 请尽快修改密码！";
			String[] connect = enrichEmailInfo(info);
			MailUtil.sendEmail(PropertyUtil.getProperty("mail.from.user"), user.getMail(), connect);
			
			
		} catch (Exception e) {
			logger.error(e);
			result.setMsg("failed");
			result.setSuccess(false);
		}
		
		return result;
	}
	
	@RequestMapping("/authCode")
	public void getAuthCode(HttpServletRequest request, HttpServletResponse response,HttpSession session)
            throws IOException {
        int width = 63;
        int height = 37;
        Random random = new Random();
        //设置response头信息
        //禁止缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
 
        //生成缓冲区image类
        BufferedImage image = new BufferedImage(width, height, 1);
        //产生image类的Graphics用于绘制操作
        Graphics g = image.getGraphics();
        //Graphics类的样式
        g.setColor(this.getRandColor(200, 250));
        g.setFont(new Font("Times New Roman",0,28));
        g.fillRect(0, 0, width, height);
        //绘制干扰线
        for(int i=0;i<Constans.FOURTY;i++){
            g.setColor(this.getRandColor(130, 200));
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int x1 = random.nextInt(12);
            int y1 = random.nextInt(12);
            g.drawLine(x, y, x + x1, y + y1);
        }
 
        //绘制字符
        String strCode = "";
        for(int i=0;i<Constans.FOUR;i++){
            String rand = String.valueOf(random.nextInt(10));
            strCode = strCode + rand;
            g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
            g.drawString(rand, 13*i+6, 28);
        }
        //将字符保存到session中用于前端的验证
        session.setAttribute("strCode", strCode);
        g.dispose();
 
        ImageIO.write(image, "JPEG", response.getOutputStream());
        response.getOutputStream().flush();
 
    }
	
	/**
	 * 
	 *@Description:
	 *-----------------------------------------------------
	 *Author			date				comments
	 *Zeng,Weilong		2019年7月4日			get color
	 *-----------------------------------------------------
	 * @return Color
	 */
	private  Color getRandColor(int fc,int bc){
        Random random = new Random();
        if(fc>Constans.TWOFIVEFIVE){
        	 fc = 255;
        }
        if(bc>Constans.TWOFIVEFIVE){
        	bc = 255;
        }
            
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r,g,b);
    }

}
