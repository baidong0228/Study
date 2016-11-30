/**
 * 
 */
package org.app.base.service;

import org.app.base.service.redis.DaoInvocationHandler;

import java.lang.reflect.Proxy;

/**
 *
 * @author Bdong
 */
public abstract class AbstractBaseService {

	/**
	 * redis代理
	 * @param intfClass
	 * @param mapperInstance
     * @return
     */
	public Object getProxy(Class<?> intfClass,Object mapperInstance) {
		return Proxy.newProxyInstance(intfClass.getClassLoader(), new Class<?>[]{intfClass}, new DaoInvocationHandler(mapperInstance));
	}
	
}
