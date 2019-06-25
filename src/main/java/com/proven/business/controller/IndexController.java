/**  
* @Title: IndexController.java 
* @author Administrator  
* @date 2019年6月13日  
* @version V1.0  
*/ 
package com.proven.business.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.proven.base.vo.Result;
import com.proven.business.dtos.CommentDto;
import com.proven.business.model.Comment;
import com.proven.business.model.PostDetail;
import com.proven.business.model.PostTitle;
import com.proven.business.model.Reply;
import com.proven.business.model.Theme;
import com.proven.business.service.CommentService;
import com.proven.business.service.PostDetailService;
import com.proven.business.service.PostTitleService;
import com.proven.business.service.ReplyService;
import com.proven.business.service.ThemeService;
import com.proven.parambean.CommentParam;
import com.proven.system.model.User;
import com.proven.utils.FileUtils;
import com.proven.utils.SpringUtil;

import tk.mybatis.mapper.util.StringUtil;

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
	
	@Autowired
	private ReplyService replyService;
	
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
	
	/**
	 * 
	 *@Description:get deatil page
	 *-----------------------------------------------------
	 *Author			date				comments
	 *Zeng,Weilong		2019年6月21日				init method
	 *-----------------------------------------------------
	 * @return String
	 */
	@RequestMapping("/detail")
	public String detail(int id,Model model){
		logger.info("detail method,and id= "+id);
		User user = SpringUtil.getCurrentUser();
		PostTitle postTitle = postTitleService.selectByKey(id);
		//update post title hot number
		postTitle.setHotNumber(postTitle.getHotNumber()+1);
		postTitleService.update(postTitle);
		
		//update post Detail watch number
 		PostDetail postDetail = postDetailService.selectByPostId(id);
 		postDetail.setWatchNumber(postDetail.getWatchNumber()+1);
 		postDetailService.update(postDetail);
 		//get previous title id
 		int previousId = id-1;
 		if(previousId<=0){
 			previousId=0;
 		}
 		PostTitle prePostTitle = postTitleService.selectByKey(previousId);
 		if(prePostTitle!=null){
 			model.addAttribute("previousId", previousId);
 		}
 		//get next title id
 		int nextId= id+1;
 		PostTitle nextPostTitle = postTitleService.selectByKey(nextId);
 		if(nextPostTitle!=null){
 			model.addAttribute("nextId", nextId);
 		}
 		
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
			result.setMsg("还没登录，不能评论相关信息!");
			result.setSuccess(false);
			result.setErrorCode(100);
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
	 * 
	* @Title: getComments  
	* @Description: get comments
	* @return PageInfo<Comment> 
	* @throws
	* Author:Zeng,weilong
	* @date 2019年6月19日
	 */
	@RequestMapping("getComments")
	@ResponseBody
	public PageInfo<CommentDto> getComments(int commentId,int page,int row){
		return commentService.getComments(commentId,page,row);
	}
	
	/**
	 * 
	 *@Description:save reply
	 *-----------------------------------------------------
	 *Author			date				comments
	 *Zeng,Weilong		2019年6月21日				init method
	 *-----------------------------------------------------
	 * @return Result
	 */
	@RequestMapping("saveReply")
	@ResponseBody
	public Result saveReply(CommentParam param){
		Result result = new Result("success",true);
		User user = SpringUtil.getCurrentUser();
		if(user==null){
			result.setMsg("还没登录，不能回复相关信息!");
			result.setSuccess(false);
			result.setErrorCode(100);
			return result;
		}
		try {
			Comment comment = commentService.selectByKey(param.getCommentId());			
			//enrich reply bean and save reply
			Reply reply = new Reply();
			reply.setCommentId(param.getCommentId());
			reply.setContent(param.getComment());
			reply.setCreateDate(new Date());
			reply.setFromName(user.getName());
			reply.setFromUid(user.getUid());
			
			if(param.getReplyId()==0||StringUtil.isEmpty(Integer.toString(param.getReplyId()))){
				reply.setReplyId(0);
				reply.setToName(comment.getCreateName());
				reply.setToUid(comment.getCreateBy());
			}else{
				reply.setReplyId(param.getReplyId());
				Reply rep = replyService.selectByKey(param.getReplyId());
				reply.setToName(rep.getFromName());
				reply.setToUid(rep.getFromUid());
			
			}
			//update comment's repeat number
			PostDetail postDetail = postDetailService.selectByKey(comment.getDetailId());
			postDetail.setRepeatNum(postDetail.getRepeatNum()+1);
			postDetailService.update(postDetail);
			replyService.save(reply);
		} catch (Exception e) {
			logger.error(e);
			result.setMsg("saveReply method have a error!");
			result.setSuccess(false);
		}
		return result;
	}
	
	/**
	 * 
	 *@Description:file download
	 *-----------------------------------------------------
	 *Author			date				comments
	 *Zeng,Weilong		2019年6月21日				init method
	 *-----------------------------------------------------
	 * @return void
	 */
	@RequestMapping("downloadFile")
	public void downloadFile(HttpServletResponse res,int detailId) throws IOException{
		PostDetail deatil = postDetailService.selectByKey(detailId);
		try {
			FileUtils.fileDownload(res, deatil.getAttachUrl(),deatil.getAttachName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	* @Title: linkOrTread  
	* @Description: add link or tread method 
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
	
	/**
	 * 
	 *@Description:
	 *-----------------------------------------------------
	 *Author			date				comments
	 *Zeng,Weilong		2019年6月25日			show the message of the system
	 *-----------------------------------------------------
	 * @return String
	 */
	@RequestMapping("/message")
	public String message(){
		return "message";
	}
	
}
