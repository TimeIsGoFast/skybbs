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
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import com.proven.base.vo.FileVo;
import com.proven.system.controller.UserController;

/**  
* @ClassName: FileUtils  
* @author Administrator  
* @date 2019年6月21日    
*/
public class FileUtils {
	private static final Logger logger  = Logger.getLogger(FileUtils.class);
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
	
	/**
	 * 
	 *@Description:
	 *-----------------------------------------------------
	 *Author			date				comments
	 *Zeng,Weilong		2019年6月29日				init method
	 *-----------------------------------------------------
	 * @return FileVo
	 */
	public static FileVo uploadFile(MultipartFile imgfile,String path) {
		String originFileName = imgfile.getOriginalFilename();
		logger.info("fileName = "+originFileName);
		String filePath = "";
		String relPath = "";
		if(imgfile!=null&&originFileName!=null&&originFileName.length()>0){
			
			//file path is source + yyyyMM+newFileName
			String newFileName = UUID.randomUUID()+originFileName.substring(originFileName.lastIndexOf("."));
			String dateStr = DateFormatUtil.getyyyyMMStr(new Date());
		    filePath = path+dateStr;
			//if file path not exist,then create file
			File file  = new File(filePath);
			if(!file.exists()){
				file.mkdirs();
			}
			filePath = filePath+File.separator+newFileName;
			File newFile  = new File(filePath);
			logger.info("uploadFile method,the file path for save is "+filePath);
			relPath ="/"+dateStr+"/"+newFileName;
			try {
				imgfile.transferTo(newFile);
			} catch (IllegalStateException e) {
				logger.error(e);
				e.printStackTrace();
			} catch (IOException e) {
				logger.error(e);
				e.printStackTrace();
			}
		}
		return new FileVo(originFileName,relPath);
		
	}

}
