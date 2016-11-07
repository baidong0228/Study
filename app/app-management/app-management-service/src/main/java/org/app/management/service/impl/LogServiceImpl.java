/*   
 * Copyright (c) 2016-2026 Founder Bdong. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Founder.   
 *   
 */     
package org.app.management.service.impl;


import org.app.base.dao.ILogDao;
import org.app.base.domain.Log;
import org.app.management.service.ILogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("logServiceImpl")
public class LogServiceImpl implements ILogService {
	@Resource(name="logDao")
	private ILogDao logDao;
	
	public int insertSelective(Log record) {
		// TODO Auto-generated method stub
		return logDao.insertSelective(record);
	}

}
  