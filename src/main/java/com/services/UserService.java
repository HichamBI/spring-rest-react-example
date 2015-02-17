/*
 * Created by Hicham B.I.
 */

package com.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class UserService {

    public Collection<User> getUsers() {
        return new ArrayList<User>(
                Arrays.asList(
                        new User(1, "Hei"),
                        new User(2, "BK-201")
                ));
    }
}
