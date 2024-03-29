package com.proven.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.proven.constans.Constans;
import com.proven.system.model.User;



/**
 * 
* @ClassName: SpringUtil  
* @author Administrator  
* @date 2019年7月18日
 */
public class SpringUtil implements ApplicationContextAware {
	/**
	 * 当前IOC
	 */
	private static ApplicationContext applicationContext;

	/**
	 * 设置当前上下文环境，此方法由spring自动装配
	 */
	@Override
	public void setApplicationContext(ApplicationContext arg0) {
		applicationContext = arg0;
	}

	/**
	 * 从当前IOC获取bean
	 * 
	 * @param id
	 *            bean的id
	 * @return
	 */
	public static Object getBean(String id) {
		Object object = null;
		object = applicationContext.getBean(id);
		return object;
	}

	public static void setSession(String key, Object obj) {
		Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser) {
			Session session = currentUser.getSession();
			if (null != session) {
				session.setAttribute(key, obj);
			}
		}
	}

	public static Object getObject(String key) {
		Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser) {
			Session session = currentUser.getSession();
			if (null != session) {
				return session.getAttribute(key);
			}
		}
		return null;
	}

	public static User getCurrentUser() {
		User currentUser = null;
		if (SpringUtil.getObject(Constans.CURRENT_USER) != null) {
			currentUser = (User) SpringUtil.getObject(Constans.CURRENT_USER);
		}
		return currentUser;
	}

	
	

}

