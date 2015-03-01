/*
 * Created by Hicham B.I.
 */

package com.dao;

import com.TestCase;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.model.User;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@DatabaseSetup("data.xml")
public class UserDaoTest extends TestCase {

    @Autowired
    UserDao userDao;


    @Test
    public void test_add_user() {
        Assertions.assertThat(userDao.addUser(new User(4, "Ace"))).isEqualToComparingFieldByField(new User(4, "Ace"));
    }

    @Test
    @DatabaseTearDown("data.xml")
    public void test_find_all() {
        Assertions.assertThat(userDao.findAll()).extracting("name").containsOnly("Luffy", "Naruto", "Ichigo");
    }
}