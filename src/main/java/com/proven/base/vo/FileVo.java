/**  
* @Description: 
* @author Administrator  
* @date 2019年6月21日  
* @version V1.0  
*/ 
package com.proven.base.vo;

/**  
* @ClassName: FileVo  
* @author Administrator  
* @date 2019年6月21日    
*/
public class FileVo {
	private String filePath;
	private String fileName;
	
	public FileVo(){}
	
	public FileVo(String fileName,String filePath){
		this.fileName = fileName;
		this.filePath = filePath;
	}
	
	public void setFilePath(String filePath){
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileUrl) {
		this.fileName = fileUrl;
	}

	public String getFilePath() {
		return filePath;
	}
	
}
