/**  
* @Title: BlogController.java 
* @author Administrator  
* @date 2019年6月10日  
* @version V1.0  
*/ 
package com.proven.business.controller;


import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.proven.base.vo.FileVo;
import com.proven.business.model.Config;
import com.proven.business.model.PostDetail;
import com.proven.business.model.PostTitle;
import com.proven.business.model.Theme;
import com.proven.business.service.ConfigService;
import com.proven.business.service.PostDetailService;
import com.proven.business.service.PostTitleService;
import com.proven.business.service.ThemeService;
import com.proven.parambean.PostParam;
import com.proven.system.model.User;
import com.proven.utils.DateFormatUtil;
import com.proven.utils.PropertyUtil;
import com.proven.utils.SpringUtil;

/**  
* @ClassName: BlogController  
* @author Administrator  
* @date 2019年6月10日    
*/
@Controller
@RequestMapping("/blog")
public class BlogController {
	private static final Logger logger  = Logger.getLogger(BlogController.class);
	
	private static boolean attach = false;
	@Autowired
	private ThemeService themeService;
	
	@Autowired
	private PostTitleService postTitleService;
	
	@Autowired
	private PostDetailService postDetailService;
	
	@Autowired
	private ConfigService configService;

	
	@RequestMapping("/render")
	public String render(Model model){
		List<Theme> themeList = themeService.selectAll();
		model.addAttribute("themes", themeList);
		return "writeBlog/writeBlog";
	}
	
	
	/**
	 * 
	 *@Description:
	 *-----------------------------------------------------
	 *Author			date				comments
	 *Zeng,Weilong		2019年6月21日			
	 *-----------------------------------------------------
	 * @return String
	 */
	@RequestMapping("/savePostDetail")
	public String savePostDetail(Model model,HttpServletRequest request,@RequestParam MultipartFile attachFile,PostParam param){
		logger.info("themeId = "+param.getThemeId()+",title= "+param.getTitle()+", content = "+param.getContent());
		User user = SpringUtil.getCurrentUser();
		FileVo fileVo = uploadFile(attachFile);
		PostTitle postTitle = new PostTitle();
		PostDetail postDetail = new PostDetail();
		enrichPostTitle(postTitle,user,param);
		enrichPostDetail(postDetail,user,param);
		int id = postTitleService.insert(postTitle);
		postDetail.setPostId(id);
		if(attach){
			postDetail.setAttachName(fileVo.getFileName());
			postDetail.setAttachUrl(fileVo.getFilePath());
		}
		
		postDetailService.save(postDetail);
		
		//save theme when add a post
		Theme theme = themeService.selectByKey(Integer.parseInt(param.getThemeId()));
		theme.setPostNumber(theme.getPostNumber()+1);
		themeService.update(theme);
		List<Config> configList = configService.getConfigListByTypeId(1);
		List<Theme> themeList = themeService.selectAll();
		model.addAttribute("postTypes", configList);
		model.addAttribute("themes", themeList);
		return "redirect:/index.do";
	}
	
	/**  
	* @param param 
	 * @Title: enrichPostDetail  
	* @Description: 
	* @return void 
	* @throws
	* Author:Zeng,weilong
	* @date 2019年6月16日
	*/
	private void enrichPostDetail(PostDetail postDetail, User user, PostParam param) {
		postDetail.setContent(param.getContent());
		postDetail.setCreateBy(user.getUid());
		postDetail.setCreateDate(new Date());
		postDetail.setCreateName(user.getName());
		postDetail.setUpdateBy(user.getUid());
		postDetail.setUpdateDate(new Date());
		postDetail.setRepeatNum(0);
		postDetail.setWatchNumber(0);
		
	}

	/**  
	* @param param 
	 * @Title: enrichPostTitle  
	* @Description: 
	* @return void 
	* @throws
	* Author:Zeng,weilong
	* @date 2019年6月16日
	*/
	private void enrichPostTitle(PostTitle postTitle, User user, PostParam param) {
		postTitle.setAuthor(user.getName());
		postTitle.setCreateBy(user.getUid());
		postTitle.setHotNumber(0);
		postTitle.setPostTime(new Date());
		postTitle.setThemeId(Integer.parseInt(param.getThemeId()));
		postTitle.setTitle(param.getTitle());
		if("admin".equals(user.getRemark())){
			postTitle.setTypeId(2);
		}else{
			postTitle.setTypeId(1);
		}
		postTitle.setUpdateBy(user.getUid());
		postTitle.setUpdateDate(new Date());
		if(attach){
			postTitle.setAttach(1);
		}else{
			postTitle.setAttach(0);
		}
		
		
		
	}

	/**
	 * 
	* @Title: uploadFile  
	* @Description: upload file
	* @return String 
	* @throws
	* Author:Zeng,weilong
	* @date 2019年6月16日
	 */
	private static FileVo uploadFile(MultipartFile attachFile){
		String originFileName = attachFile.getOriginalFilename();
		logger.info("fileName = "+originFileName);
		String filePath = "";
		if(attachFile!=null&&originFileName!=null&&originFileName.length()>0){
			attach = true;
			
			//file path is source + yyyyMM+newFileName
			String newFileName = UUID.randomUUID()+originFileName.substring(originFileName.lastIndexOf("."));
			String dateStr = DateFormatUtil.getyyyyMMStr(new Date());
		    filePath = PropertyUtil.getProperty("upload.file.path")+dateStr;
			//if file path not exist,then create file
			File file  = new File(filePath);
			if(!file.exists()){
				file.mkdirs();
			}
			filePath = filePath+File.separator+newFileName;
			File newFile  = new File(filePath);
			logger.info("uploadFile method,the file path for save is "+filePath);
			try {
				attachFile.transferTo(newFile);
			} catch (IllegalStateException e) {
				logger.error(e);
				e.printStackTrace();
			} catch (IOException e) {
				logger.error(e);
				e.printStackTrace();
			}
		}
		return new FileVo(originFileName,filePath);
	}
	
	
	
	
}
