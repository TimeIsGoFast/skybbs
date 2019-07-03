/**  
* @Description: 
* @author Administrator  
* @date 2019年6月27日  
* @version V1.0  
*/ 
package com.proven.base.test.controller;

import org.junit.Test;

import com.proven.system.controller.UserController;

/**  
* @ClassName: UserControllerTest  
* @author Administrator  
* @date 2019年6月27日    
*/
public class UserControllerTest {
	@Test
	public void  enrichConnectTest(){
		
		UserController userController = new UserController();
		
		String[] commnets = userController.enrichConnect(2);
		System.out.println(commnets.toString());
	}
}
