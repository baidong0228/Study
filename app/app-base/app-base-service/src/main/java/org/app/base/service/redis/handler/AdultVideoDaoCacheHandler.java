package org.app.base.service.redis.handler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.app.base.dao.IAdultVideoStarDao;
import org.app.base.domain.AdultVideoStar;
import org.app.base.service.redis.FilterMethodName;
import org.app.base.service.utils.ApplicationContextUtil;
import org.springframework.stereotype.Component;

import redis.clients.jedis.JedisCluster;

//AdultVideoDaoCacheHandler类只负责IAdultVideoStarDao接口的方法的缓存处理
@FilterMethodName(methodName = "selectByPrimaryKey", type = IAdultVideoStarDao.class)
@Component
public class AdultVideoDaoCacheHandler implements CacheHandler {

	public Object process(Object[] args, Method method, Object instance) {

		JedisCluster jedisCluster = (JedisCluster) ApplicationContextUtil
				.getApplicationContext().getBean("jedisCluster");

		Object result = null;
		if (jedisCluster.exists("AdultVideoStar"+args[0])) {
			result = jedisCluster.get("AdultVideoStar"+args[0]);
		} else {
			try {
				result = method.invoke(instance, args);
				jedisCluster.set("AdultVideoStar"+args[0],((AdultVideoStar)result).getChinesename());
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
}
