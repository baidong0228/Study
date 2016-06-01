/*   
 * Copyright (c) 2016-2026 Founder Bdong. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Founder.   
 *   
 */     
package org.app.base.service.imp;    

import org.app.base.dao.IPersonDao;
import org.app.base.domain.Person;
import org.app.base.service.IPersonServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("personServiceTest")
public class PersonServiceTestImpl implements IPersonServiceTest{
	@Autowired    
    private IPersonDao personDao; 
	@Override
	public Person selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return personDao.selectByPrimaryKey(id);
	}

}
  