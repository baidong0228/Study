/*   
 * Copyright (c) 2016-2026 Founder Bdong. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Founder.   
 *   
 */
package org.app.base.service.impl;

import org.app.base.dao.IGroupDao;
import org.app.base.domain.Group;
import org.app.base.service.IGroupService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("groupServiceImpl")
public class GroupServiceImpl implements IGroupService {
    @Resource(name = "groupDao")
    private IGroupDao groupDao;

    public Group selectByPrimaryKey(String id) {
        // TODO Auto-generated method stub
        return groupDao.selectByPrimaryKey(id);
    }

}
  