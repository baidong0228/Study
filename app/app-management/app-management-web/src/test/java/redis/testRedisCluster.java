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
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.JedisCluster;

/**
 * This class of testRedisCluster is used for ...
 *
 * @author Bdong
 * @version 1.0 16/11/14 20:45
 */

public class TestRedisCluster {
    private static Logger logger = Logger.getLogger("TestRedisCluster");
    private ApplicationContext ac = null;
    private JedisCluster jedisCluster = null;
    @Before
    public void loadBeanDefinitions(){
        ac = new ClassPathXmlApplicationContext("redis/redis.xml");
        jedisCluster = (JedisCluster) ac.getBean("jedisCluster");
    }

    @Test
    public void test() throws Exception {
//        for(int i = 0 ; i < 100 ; i++) {
//            jedisCluster.set("key" + i, "value" + i);
//        }
        jedisCluster.set("key321","value1312");
        logger.info("OK!");
    }
}
