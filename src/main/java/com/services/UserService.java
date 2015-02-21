/*
 * Created by Hicham B.I.
 */

package com.services;

import com.dao.UserDao;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public Collection<User> getUsers() {
        return userDao.findAll();
    }
}
