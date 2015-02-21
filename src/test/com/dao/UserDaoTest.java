/*
 * Created by Hicham B.I.
 */

package com.dao;

import com.config.PersistenceContext;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceContext.class)
public class UserDaoTest{

    @Autowired
    UserDao userDao;

    @Test
    public void test_find_all() {
        userDao.findAll();
        Assertions.assertThat(userDao.findAll()).extracting("name").contains("Hicham");
    }

}