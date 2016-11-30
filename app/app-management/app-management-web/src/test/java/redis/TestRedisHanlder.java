package redis;/*   
 * Copyright (c) 2016-2026 Founder Bdong. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Founder.   
 *   
 */

import org.apache.log4j.Logger;
import org.app.base.service.IAdultVideoStarService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;

/**
 * This class of TestRedisHanlder is used for ...
 *
 * @author Bdong
 * @version 1.0 16/11/15 10:46
 */
public class TestRedisHanlder {
    private static Logger logger = Logger.getLogger("TestRedisHanlder");
    private ApplicationContext ac = null;
    @Resource(name = "avStarServiceImpl")
    private IAdultVideoStarService avStarServiceImpl;
    @Before
    public void loadBeanDefinitions(){
        ac = new ClassPathXmlApplicationContext("spring-config.xml");
        avStarServiceImpl = (IAdultVideoStarService) ac.getBean("avStarServiceImpl");
    }

    @Test
    public void test() throws Exception {
//        Object o = avStarServiceImpl.selectByPrimaryKey(1);
//        logger.info(o.toString());
    }
}
