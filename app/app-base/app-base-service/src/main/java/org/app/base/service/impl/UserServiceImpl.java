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

import org.app.base.dao.IUserDao;
import org.app.base.domain.User;
import org.app.base.domain.vo.UserVO;
import org.app.base.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("userServiceImpl")
public class UserServiceImpl implements IUserService {
    @Resource(name = "userDao")
    private IUserDao userDao;

    public User selectByPrimaryKey(String id) {
        // TODO Auto-generated method stub
        return userDao.selectByPrimaryKey(id);
    }

    public UserVO selectByName(String username) {
        // TODO Auto-generated method stub
        return userDao.selectByName(username);
    }

    public int updateByPrimaryKeySelective(User record) {
        // TODO Auto-generated method stub
        return userDao.updateByPrimaryKeySelective(record);
    }

}
  