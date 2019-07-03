/**  
* @Description: 
* @author Administrator  
* @date 2019年7月3日  
* @version V1.0  
*/ 
package com.proven.base.test.util;

import org.junit.Test;

import com.proven.utils.CommonUtil;

/**  
* @ClassName: CommonUtilTest  
* @author Administrator  
* @date 2019年7月3日    
*/
public class CommonUtilTest {

	@Test
	public void getVerifyCodeTest(){
		
		System.out.println(CommonUtil.getVerifyCode(4));
	}
	
	@Test
	public void getRandomPwdTest(){
		System.out.println(CommonUtil.getRandomPwd(6));
	}
}
