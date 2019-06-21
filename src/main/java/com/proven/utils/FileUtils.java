/**  
* @Description: 
* @author Administrator  
* @date 2019年6月21日  
* @version V1.0  
*/ 
package com.proven.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

/**  
* @ClassName: FileUtils  
* @author Administrator  
* @date 2019年6月21日    
*/
public class FileUtils {
	/**
	 * 
	 *@param fileName 
	 * @Description:file download util method
	 *-----------------------------------------------------
	 *Author			date				comments
	 *Zeng,Weilong		2019年6月21日				init method
	 *-----------------------------------------------------
	 * @return HttpServletResponse
	 * @throws IOException 
	 */
	public static HttpServletResponse fileDownload(HttpServletResponse res,String filePath, String fileName) throws IOException{
		ServletOutputStream  out = null;
		File file  = new File(filePath);
		FileInputStream input = null;
		res.reset();
		res.setCharacterEncoding("utf-8");
		res.setContentType("application/x-msdownload");  
		res.setHeader("Content-disposition", "attachment;filename="+fileName);
		input= new FileInputStream(file);
		byte[] buffer = new byte[1024];
		out = res.getOutputStream();
		int len=0;
		while((len=input.read(buffer))!=-1){
			out.write(buffer,0,len);
		}
		if(out!=null){
			out.close();
		}
		if(input!=null){
			input.close();
		}

		return res;
		
	}

}
