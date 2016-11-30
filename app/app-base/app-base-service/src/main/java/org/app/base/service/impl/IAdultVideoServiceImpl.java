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


import org.app.base.dao.IAdultVideoStarDao;
import org.app.base.domain.AdultVideoStar;
import org.app.base.service.AbstractBaseService;
import org.app.base.service.IAdultVideoStarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("avStarServiceImpl")
public class IAdultVideoServiceImpl extends AbstractBaseService implements IAdultVideoStarService {
    @Resource(name = "avStarDao")
    private IAdultVideoStarDao avStarDao;

    public AdultVideoStar selectByPrimaryKey(Integer id) {
//        IAdultVideoStarDao avStarDaoProxy = (IAdultVideoStarDao) getProxy(IAdultVideoStarDao.class,avStarDao);
//        return avStarDaoProxy.selectByPrimaryKey(1);
        return avStarDao.selectByPrimaryKey(1);
    }

    public List<AdultVideoStar> selectAll() {
        return avStarDao.selectAll();
    }
}
  