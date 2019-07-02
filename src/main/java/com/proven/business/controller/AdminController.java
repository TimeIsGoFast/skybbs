/**  
* @Description: 
* @author Administrator  
* @date 2019年6月30日  
* @version V1.0  
*/ 
package com.proven.business.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.proven.base.vo.Result;
import com.proven.business.model.Config;
import com.proven.business.model.PostTitle;
import com.proven.business.model.Theme;
import com.proven.business.service.CommentService;
import com.proven.business.service.ConfigService;
import com.proven.business.service.PostDetailService;
import com.proven.business.service.PostTitleService;
import com.proven.business.service.ReplyService;
import com.proven.business.service.ThemeService;

/**  
* @ClassName: AdminController  
* @author Administrator  
* @date 2019年6月30日    
*/
@Controller
@RequestMapping("admin")
public class AdminController {
	private static final Logger logger  = Logger.getLogger(AdminController.class);
	
	@Autowired
	private PostTitleService postTitleService;
	
	@Autowired
	private PostDetailService detailService;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private ThemeService themeService;
	
	@Autowired
	private ReplyService replyService;
	
	@Autowired
	private ConfigService configService;
	/**
	 * 
	 *@Description:
	 *-----------------------------------------------------
	 *Author			date				comments
	 *Zeng,Weilong		2019年6月30日			forward to admin page
	 *-----------------------------------------------------
	 * @return String
	 */
	@RequestMapping("render")
	public String render(){
		return "admin/index";
	}
	
	/**
	 * 
	 *@Description:
	 *-----------------------------------------------------
	 *Author			date				comments
	 *Zeng,Weilong		2019年6月30日			forward to user page
	 *-----------------------------------------------------
	 * @return String
	 */
	@RequestMapping("/user")
	public String user(){
		return null;
	}
	
	/**
	 * 
	 *@Description:
	 *-----------------------------------------------------
	 *Author			date				comments
	 *Zeng,Weilong		2019年6月30日			forward to admin post page
	 *Zeng,Weilong		2019年7月01日			add themes and types to page
	 *-----------------------------------------------------
	 * @return String
	 */
	@RequestMapping("/post")
	public String post(Model model){
		//get some data for theme and type
		List<Theme> themes = themeService.selectAll();
		List<Config> types = configService.getConfigListByGroupId(1);		
		model.addAttribute("themes", themes);
		model.addAttribute("types", types);
		return "admin/post/post";
	}
	
	/**
	 * 
	 *@Description:
	 *-----------------------------------------------------
	 *Author			date				comments
	 *Zeng,Weilong		2019年6月30日			get post page init data
	 *-----------------------------------------------------
	 * @return String
	 */
	@RequestMapping("/getPostPage")
	@ResponseBody
	public PageInfo<PostTitle> getPostPage(int page,int row,String search){
		
		return postTitleService.getAdminTitleData(page, row,search);
		
	}
	
	/**
	 * 
	 *@Description:
	 *-----------------------------------------------------
	 *Author			date				comments
	 *Zeng,Weilong		2019年6月30日			deletePost method
	 *-----------------------------------------------------
	 * @return Result
	 */
	@RequestMapping("/deletePost")
	@ResponseBody
	public Result deletePost(int titleId){
		Result result = new Result("success",true);
		
		try {
			PostTitle title = postTitleService.selectByKey(titleId);
			Theme theme = themeService.selectByKey(title.getThemeId());
			theme.setPostNumber(theme.getPostNumber()-1);
			themeService.update(theme);
			//delete postTitle
			postTitleService.delete(titleId);
			//delete postDeatil
			detailService.deleteBytitleId(titleId);
			//delete comment
			commentService.deleteByTitleId(titleId);
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
	 *Zeng,Weilong		2019年6月30日			get comment page init data
	 *-----------------------------------------------------
	 * @return String
	 */
	@RequestMapping("/getCommentPage")
	@ResponseBody
	public PageInfo<PostTitle> getCommentPage(int page,int row,String search){
		
		return commentService.getAdminCommentData(page, row,search);
		
	}
	
	/**
	 * 
	 *@Description:
	 *-----------------------------------------------------
	 *Author			date				comments
	 *Zeng,Weilong		2019年6月30日			deletePost method
	 *-----------------------------------------------------
	 * @return Result
	 */
	@RequestMapping("/deleteComment")
	@ResponseBody
	public Result deleteComment(int commentId){
		Result result = new Result("success",true);
		
		try {
			//delete comment
			commentService.delete(commentId);
			
			//delete reply
			replyService.deleteByCommentId(commentId);
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
	 *Zeng,Weilong		2019年7月1日			forward to comment page
	 *-----------------------------------------------------
	 * @return String
	 */
	@RequestMapping("/comment")
	public String comment(){
		return "admin/post/comment";
	}

	/**
	 * 
	 *@Description:
	 *-----------------------------------------------------
	 *Author			date				comments
	 *Zeng,Weilong		2019年7月1日			update post
	 *-----------------------------------------------------
	 * @return Result
	 */
	@RequestMapping("/updateTitle")
	@ResponseBody
	public Result updateTitle(PostTitle post){
		Result result = new Result("success",true);
		
		try {
			PostTitle oldPost = postTitleService.selectByKey(post.getId());			
			oldPost.setTypeId(post.getTypeId());
			if(post.getThemeId()!=oldPost.getThemeId()){
				//update theme data
				Theme theme1 = themeService.selectByKey(oldPost.getThemeId());
				theme1.setPostNumber(theme1.getPostNumber()-1);
				
				Theme theme2 = themeService.selectByKey(post.getThemeId());
				theme2.setPostNumber(theme2.getPostNumber()+1);
				themeService.update(theme1);
				themeService.update(theme2);
				
				oldPost.setThemeId(post.getThemeId());
			}
			
			
			postTitleService.update(oldPost);
		} catch (Exception e) {
			logger.error(e);
			result.setMsg("failed");
			result.setSuccess(false);
		}
		
		return result;
	}
	
}
