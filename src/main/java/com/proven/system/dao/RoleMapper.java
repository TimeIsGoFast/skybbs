package com.proven.system.dao;

import java.util.List;

import com.proven.system.model.Role;
import tk.mybatis.mapper.common.Mapper;
/**
 * 
* @ClassName: RoleMapper  
* @author Administrator  
* @date 2019年7月18日
 */
public interface RoleMapper extends Mapper<Role> {

	List<Role> getRolesByUid(String uid);
}