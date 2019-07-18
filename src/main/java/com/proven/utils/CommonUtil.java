package com.proven.utils;

import java.util.Random;
/**
 * 
* @ClassName: CommonUtil  
* @author Administrator  
* @date 2019年7月18日
 */
public class CommonUtil {
	
	private static Random rd = new Random();
	/**
	 * 
	 *@Description:
	 *-----------------------------------------------------
	 *Author			date				comments
	 *Zeng,Weilong		2019年7月3日			get all char
	 *-----------------------------------------------------
	 * @return char[]
	 */
	public static char[] charArray(){
        int number = 1234567890;
        String str ="qwertyuiopasdfghjklzxcvbnm";
        String upperCaseStr=str.toUpperCase();
        String word=str+upperCaseStr+number;
        char[] c=word.toCharArray();
 
        return c;
    }

	/**
	 * 
	 *@Description:
	 *-----------------------------------------------------
	 *Author			date				comments
	 *Zeng,Weilong		2019年7月3日			getVerifyCode
	 *-----------------------------------------------------
	 * @return String
	 */
	public static String getVerifyCode(int num){
		StringBuilder code= new StringBuilder();
		
		for(int i=0;i<num;i++){
			code.append(rd.nextInt(9));
		}
		
		return code.toString();
	}
	
	/**
	 * 
	 *@Description:
	 *-----------------------------------------------------
	 *Author			date				comments
	 *Zeng,Weilong		2019年7月3日			getRandomPwd
	 *-----------------------------------------------------
	 * @return String
	 */
	public static String getRandomPwd(int num){
		//获取包含26个字母大小写和数字的字符数组
	  char[] c= CommonUtil.charArray();

      Random rd = new Random();
      StringBuilder code= new StringBuilder();
      for (int k = 0; k <num; k++) {
    	  //随机获取数组长度作为索引
          int index = rd.nextInt(c.length);
          code.append(c[index]);
      } 
      return code.toString();

	}
}
