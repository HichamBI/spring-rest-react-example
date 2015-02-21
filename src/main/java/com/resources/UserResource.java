/*
 * Created by Hicham B.I.
 */

package com.resources;

import com.model.User;
import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("user")
public class UserResource {

    @Autowired
    private UserService userService;

    @RequestMapping("/all")
    public Collection<User> getUsers() {
        return userService.getUsers();
    }
}