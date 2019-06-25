/**  
* @Title: PostTitleServiceImpl.java 
* @author Administrator  
* @date 2019年6月15日  
* @version V1.0  
*/ 
package com.proven.business.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.proven.base.service.impl.BaseServiceImpl;
import com.proven.business.dao.PostTitleMapper;
import com.proven.business.model.PostTitle;
import com.proven.business.service.PostTitleService;

/**  
* @ClassName: PostTitleServiceImpl  
* @author Administrator  
* @date 2019年6月15日    
*/
@Service
@Transactional
public class PostTitleServiceImpl extends BaseServiceImpl<PostTitle> implements PostTitleService {
	private static final Logger logger  = Logger.getLogger(PostTitleServiceImpl.class);
	@Autowired
	private PostTitleMapper postTitleMapper;
	/**
	* <p>Title: getPostTitleData</p>  
	* <p>Description: </p>  
	* @param typeId
	* @param themeId
	* @return  
	* @see com.proven.business.service.PostTitleService#getPostTitleData(int, int)  
	*/  
	@Override
	public PageInfo<PostTitle> getPostTitleData(String typeId, String themeId,int page,int row) {
		//judge whether type id is empty
		if(StringUtils.isEmpty(typeId)){
			typeId="0";
		}
		//judge whether theme id is empty
		if(StringUtils.isEmpty(themeId)){
			themeId="1";
		}
		PageHelper.startPage(page, row);
		List<PostTitle> list = postTitleMapper.getPostTitleData(Integer.parseInt(typeId),Integer.parseInt(themeId));
		PageInfo<PostTitle> info = new PageInfo<>(list);
		return info;
	}
	/**
	* <p>Title: insert</p>  
	* <p>Description: </p>  
	* @param postTitle
	* @return  
	* @see com.proven.business.service.PostTitleService#insert(com.proven.business.model.PostTitle)  
	*/  
	@Override
	public int insert(PostTitle postTitle) {
		int id = postTitleMapper.insertReturnId(postTitle);
		logger.info("id= "+id+" renturn id= "+postTitle.getId());
		return postTitle.getId();
	}

	

}
