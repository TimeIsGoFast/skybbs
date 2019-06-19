/**  
* @Title: IndexController.java 
* @author Administrator  
* @date 2019年6月13日  
* @version V1.0  
*/ 
package com.proven.business.controller;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.proven.base.vo.Result;
import com.proven.business.model.Comment;
import com.proven.business.model.PostDetail;
import com.proven.business.model.PostTitle;
import com.proven.business.model.Theme;
import com.proven.business.service.CommentService;
import com.proven.business.service.PostDetailService;
import com.proven.business.service.PostTitleService;
import com.proven.business.service.ThemeService;
import com.proven.parambean.CommentParam;
import com.proven.system.model.User;
import com.proven.utils.SpringUtil;

/**  
* @ClassName: IndexController  
* @author Administrator  
* @date 2019年6月13日    
*/
@Controller
@RequestMapping("/index")
public class IndexController {
	private static final Logger logger  = Logger.getLogger(IndexController.class);
	@Autowired
	private ThemeService themeService;
	
	@Autowired
	private PostTitleService postTitleService;
	
	@Autowired
	private PostDetailService postDetailService;
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping("/getThemeData")
	public List<Theme> getThemeData(){
		return themeService.selectAll();
	}
	
	/**
	 * 
	* @Title: getPostTitleData  
	* @Description: 
	* @return List<PostTitle> 
	* @throws
	* Author:Zeng,weilong
	* @date 2019年6月15日
	 */
	@RequestMapping("/getPostTitleData")
	@ResponseBody
	public PageInfo<PostTitle> getPostTitleData(String typeId,String themeId,int page,int row){
		logger.info("typeId= "+typeId+",themeId= "+themeId+",page= "+page+",row= "+row);
		return postTitleService.getPostTitleData(typeId,themeId,page,row);
		
	}
	
	
	@RequestMapping("/detail")
	public String detail(int id,Model model){
		logger.info("detail method,and id= "+id);
		User user = SpringUtil.getCurrentUser();
		PostTitle postTitle = postTitleService.selectByKey(id);
		postTitle.setHotNumber(postTitle.getHotNumber()+1);
		postTitleService.update(postTitle);
 		PostDetail postDetail = postDetailService.selectByPostId(id);
 		postDetail.setWatchNumber(postDetail.getWatchNumber()+1);
 		postDetailService.update(postDetail);
		model.addAttribute("postTitle", postTitle);
		model.addAttribute("postDetail", postDetail);
		model.addAttribute("user", user);
		return "detail/detail";
	}
	
	/**
	 * 
	* @Title: chat  
	* @Description: live chat room
	* @return String 
	* @throws
	* Author:Zeng,weilong
	* @date 2019年6月19日
	 */
	@RequestMapping("/chat")
	public String chat(){
		return "tuling/tuling";
	}
	
	/**
	 * 
	* @Title: saveComment  
	* @Description:save comment method 
	* @return Result 
	* @throws
	* Author:Zeng,weilong
	* @date 2019年6月19日
	 */
	@RequestMapping("saveComment")
	@ResponseBody
	public Result saveComment(CommentParam param){
		
		Result result  = new Result();
		result.setMsg("success");
		result.setSuccess(true);
		User user = SpringUtil.getCurrentUser();
		if(user==null){
			result.setMsg("failed");
			result.setSuccess(false);
			return result;
		}
		try {
			
			Comment comment = new Comment();
			comment.setComment(param.getComment());
			comment.setTitleId(param.getTitleId());
			comment.setDetailId(param.getDetailId());
			comment.setCreateBy(user.getUid());
			comment.setCreateDate(new Date());
			comment.setCreateName(user.getName());
			comment.setLinkNum(0);
			comment.setTreadNum(0);
			commentService.save(comment);
		} catch (Exception e) {
			logger.error(e);
			result.setMsg("failed");
			result.setSuccess(false);
		}
		
		return result;
	}
	
	/**
	* @Title: linkOrTread  
	* @Description: link or tread method 
	* @return Result 
	* @throws
	* Author:Zeng,weilong
	* @date 2019年6月19日
	 */
	@RequestMapping("linkOrTread")
	@ResponseBody
	public Result linkOrTread(int commentId,String type){
		Result result = new Result();
		result.setMsg("success");
		result.setSuccess(true);
		
		try {
			Comment comment = commentService.selectByKey(commentId);
			if("link".equals(type)){
				comment.setLinkNum(comment.getLinkNum()+1);
			}else if("tread".equals(type)){
				comment.setTreadNum(comment.getTreadNum()+1);
			}else{
				result.setMsg("failed");
				result.setSuccess(false);
				return result;
			}
			commentService.update(comment);
		} catch (Exception e) {
			logger.error(e);
			result.setMsg("failed");
			result.setSuccess(false);
		}
		return result;
	}
}
