/**  
* @Title: PostParam.java 
* @author Administrator  
* @date 2019年6月16日  
* @version V1.0  
*/ 
package com.proven.parambean;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.STLang;

/**  
* @ClassName: PostParam  
* @author Administrator  
* @date 2019年6月16日    
*/
public class PostParam {
	private String themeId;
	private String title;
	private String content;
	public String getThemeId() {
		return themeId;
	}
	public void setThemeId(String themeId) {
		this.themeId = themeId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
