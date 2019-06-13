/**  
* @Title: IndexController.java 
* @author Administrator  
* @date 2019年6月13日  
* @version V1.0  
*/ 
package com.proven.business.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proven.business.model.Theme;
import com.proven.business.service.ThemeService;

/**  
* @ClassName: IndexController  
* @author Administrator  
* @date 2019年6月13日    
*/
@Controller
@RequestMapping("/index")
public class IndexController {
	@Autowired
	private ThemeService themeService;
	
	@RequestMapping("/getThemeData")
	public List<Theme> getThemeData(){
		return themeService.selectAll();
	}
	
	
	
}
