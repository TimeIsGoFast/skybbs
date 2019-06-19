/**  
* @Title: CommentServiceImpl.java 
* @author Administrator  
* @date 2019年6月19日  
* @version V1.0  
*/ 
package com.proven.business.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proven.base.service.impl.BaseServiceImpl;
import com.proven.business.model.Comment;
import com.proven.business.service.CommentService;

/**  
* @ClassName: CommentServiceImpl  
* @author Administrator  
* @date 2019年6月19日    
*/
@Service
@Transactional
public class CommentServiceImpl extends BaseServiceImpl<Comment> implements CommentService{

}
