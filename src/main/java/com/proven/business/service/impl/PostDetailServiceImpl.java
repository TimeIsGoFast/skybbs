/**  
* @Title: PostDetailServiceImpl.java 
* @author Administrator  
* @date 2019年6月16日  
* @version V1.0  
*/ 
package com.proven.business.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proven.base.service.impl.BaseServiceImpl;
import com.proven.business.model.PostDetail;
import com.proven.business.service.PostDetailService;

/**  
* @ClassName: PostDetailServiceImpl  
* @author Administrator  
* @date 2019年6月16日    
*/
@Service
@Transactional
public class PostDetailServiceImpl extends BaseServiceImpl<PostDetail> implements PostDetailService{

}
