package org.app.base.service.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextUtil implements ApplicationContextAware {

	public static ApplicationContext applicationContext;
	
	public void setApplicationContext(ApplicationContext agr)
			throws BeansException {
		applicationContext = agr;

	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	
}
