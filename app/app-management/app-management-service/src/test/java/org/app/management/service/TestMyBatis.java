/*   
 * Copyright (c) 2016-2026 Founder Bdong. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Founder.   
 *   
 */
package org.app.management.service;


import org.apache.log4j.Logger;
import org.app.base.domain.AdultVideoStar;
import org.app.base.service.IAdultVideoStarService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;


/**
 * TestMyBatis
 * This class is used for ...
 *
 * @author Bdong
 * @version 1.0, 2016年5月26日 下午5:52:24
 */
public class TestMyBatis {
    private static Logger logger = Logger.getLogger("TestMyBatis");
    private ApplicationContext ac = null;
    @Resource(name = "avStarServiceImpl")
    private IAdultVideoStarService avStarServiceImpl;

    @Before
    public void before() {
        ac = new ClassPathXmlApplicationContext("spring-config-mybatis.xml");
        avStarServiceImpl = (IAdultVideoStarService) ac.getBean("avStarServiceImpl");
    }

    @Test
    public void test() {
//        AdultVideoStar avStar = avStarServiceImpl.selectByPrimaryKey(1);
//        logger.info("ChineseName:" + avStar.getChinesename());
//        logger.info("EnglishName:" + avStar.getEnglishname());
//        logger.info("Birthday:" + avStar.getBirthday());
//        logger.info("Height:" + avStar.getHeight());
//        logger.info("Measurements:" + avStar.getMeasurements());
//        logger.info("Cup:" + avStar.getCup());
//        logger.info("Mosaic:" + avStar.getMosaic());
    }
}
  