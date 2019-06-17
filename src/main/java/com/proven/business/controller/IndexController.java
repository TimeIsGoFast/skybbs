/**  
* @Title: IndexController.java 
* @author Administrator  
* @date 2019年6月13日  
* @version V1.0  
*/ 
package com.proven.business.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.proven.business.model.PostTitle;
import com.proven.business.model.Theme;
import com.proven.business.service.PostTitleService;
import com.proven.business.service.ThemeService;

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
	
	
}
