package com.proven.utils;

import java.util.Random;

public class CommonUtil {
	
	private static Random rd = new Random();
	/**
	 * 
	 *@Description:
	 *-----------------------------------------------------
	 *Author			date				comments
	 *Zeng,Weilong		2019年7月3日			deal Boolean when type is String 
	 *-----------------------------------------------------
	 * @return int
	 */
	public static int dealBoolean(String bool){
		
		if(bool==null){
			return 0;
		}
		if(bool.equals("false")){
			return 0;
		}else if(bool.equals("true")){
			return 1;
		}else{
			return 0;
		}
		
	}
	
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
        int i = 1234567890;
        String s ="qwertyuiopasdfghjklzxcvbnm";
        String S=s.toUpperCase();
        String word=s+S+i;
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
	  char[] c= CommonUtil.charArray();//获取包含26个字母大小写和数字的字符数组
//      System.out.println(Arrays.toString(c));

      Random rd = new Random();
      StringBuilder code= new StringBuilder();
      for (int k = 0; k <num; k++) {
          int index = rd.nextInt(c.length);//随机获取数组长度作为索引
          code.append(c[index]);
      } 
      return code.toString();

	}
}
