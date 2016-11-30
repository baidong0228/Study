/**
 * 
 */
package org.app.base.service.redis;

import java.lang.annotation.*;

/**
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FilterMethodName {

	//过滤的方法
	String methodName();
	//过滤的dao类
	Class<?> type();
}
