package org.app.management.web.controller;/*   
 * Copyright (c) 2016-2026 Founder Bdong. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Founder.   
 *   
 */

import org.apache.log4j.Logger;
import org.app.base.service.impl.IAdultVideoServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * This class of TestController is used for ...
 *
 * @author Bdong
 * @version 1.0 16/11/15 11:00
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {
    private static Logger logger = Logger.getLogger(TestController.class);

    @Resource(name = "avStarServiceImpl")
    private IAdultVideoServiceImpl avStarServiceImpl;

    @RequestMapping("testRedis")
    public void testRedis(){
        Object o = avStarServiceImpl.selectByPrimaryKey(1);
        logger.info(o.toString());
    }
}
