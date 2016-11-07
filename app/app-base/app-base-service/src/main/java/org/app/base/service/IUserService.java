/*   
 * Copyright (c) 2016-2026 Founder Bdong. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Founder.   
 *   
 */     
package org.app.base.service;


import org.app.base.domain.User;
import org.app.base.domain.vo.UserVO;

/**
 * 
 * This class is used for ...   
 * @author Bdong  
 * @version   
 *       1.0, 2016年5月26日 下午5:43:21
 */
public interface IUserService {
	/**
	 * 根据id查询用户信息
	 * @param username
	 * @return  
	 * @author Bdong
	 */
	public User selectByPrimaryKey(String id);
	/**
	 * 根据用户名查询用户信息
	 * @param username
	 * @return  
	 * @author Bdong
	 */
	public UserVO selectByName(String username);
	/**
	 * 更新
	 * @param record
	 * @return  
	 * @author Bdong
	 */
	int updateByPrimaryKeySelective(User record);
}
  