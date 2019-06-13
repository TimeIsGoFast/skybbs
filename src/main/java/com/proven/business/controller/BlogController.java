/**  
* @Title: BlogController.java 
* @author Administrator  
* @date 2019年6月10日  
* @version V1.0  
*/ 
package com.proven.business.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**  
* @ClassName: BlogController  
* @author Administrator  
* @date 2019年6月10日    
*/
@Controller
@RequestMapping("/blog")
public class BlogController {

	@RequestMapping("/render")
	public String render(){
		return "writeBlog/writeBlog";
	}
	
	@RequestMapping("/detail")
	public String detail(){
		return "detail/detail";
	}
	@RequestMapping("/chat")
	public String chat(){
		return "tuling/tuling";
	}
	
}
