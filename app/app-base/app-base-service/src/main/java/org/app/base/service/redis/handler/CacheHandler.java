package org.app.base.service.redis.handler;

import java.lang.reflect.Method;

public interface CacheHandler {

	/**
	 * 处理redis缓存
	 * @param param
	 * @param method
	 * @param instance
     * @return
     */
	Object process(Object[] param, Method method, Object instance);
}
