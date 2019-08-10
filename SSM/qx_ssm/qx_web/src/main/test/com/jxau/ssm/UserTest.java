package com.jxau.ssm;

import com.jxau.ssm.dao.IUserDao;
import com.jxau.ssm.domain.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author wfl
 * @date 2019/8/8 13:43
 * @description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
public class UserTest {

    @Autowired
    private IUserDao userDao;


    @Test
    public void testFindUser() throws Exception {

        //System.out.println("userDao = " + userDao);


        UserInfo tom = userDao.findByUsername("tom");

    }
}
