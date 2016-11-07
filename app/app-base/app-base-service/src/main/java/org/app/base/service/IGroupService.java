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


import org.app.base.domain.Group;

public interface IGroupService {
	/**
	 * 根据Id查询
	 * @param id
	 * @return  
	 * @author Bdong
	 */
	Group selectByPrimaryKey(String id);
}
  