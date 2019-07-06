/**  
* @Description: 
* @author Administrator  
* @date 2019年7月6日  
* @version V1.0  
*/ 
package com.proven.base.vo;

/**  
* @ClassName: ImgResult  
* @author Administrator  
* @date 2019年7月6日    
*/
public class ImgResult {
	private int success;
	private String message;
	private String url;
	
	public ImgResult(){}
	public ImgResult(int success){
		this.success = success;
	}
	public int getSuccess() {
		return success;
	}
	public void setSuccess(int success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
