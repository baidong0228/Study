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

import org.app.base.dao.IPersonDao;
import org.app.base.domain.Person;
import org.app.management.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("personService")
public class PersonServiceImpl implements IPersonService{
	@Autowired    
    private IPersonDao personDao; 
	@Override
	public Person selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return personDao.selectByPrimaryKey(id);
	}

}
  