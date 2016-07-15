/*   
 * Copyright (c) 2016-2026 Founder Bdong. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Founder.   
 *   
 */     
package org.app.management.service.imp;    

import org.app.base.dao.IAdultVideoStarDao;
import org.app.base.domain.AdultVideoStar;
import org.app.management.service.IAdultVideoStarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
    
@Service("avStarService")
public class IAdultVideoServiceImpl implements IAdultVideoStarService {
	@Autowired    
    private IAdultVideoStarDao avStarDao;
	@Override
	public AdultVideoStar selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return avStarDao.selectByPrimaryKey(id);
	}
}
  