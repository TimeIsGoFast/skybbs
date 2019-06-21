/**  
* @Description: 
* @author Administrator  
* @date 2019年6月21日  
* @version V1.0  
*/ 
package com.proven.base.test.util;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Date;

import org.junit.Test;

import com.proven.utils.DateFormatUtil;

/**  
* @ClassName: DateFormatUtilTest  
* @author Administrator  
* @date 2019年6月21日    
*/
public class DateFormatUtilTest {

	@Test
	public void getyyyyMMStrTest() throws ParseException{
		String dateStr = "2018-06-21 00:00:00";
		Date date = DateFormatUtil.parseDate(dateStr);
		String str = DateFormatUtil.getyyyyMMStr(date);
		
		assertEquals("201806",str);
	}
}
