/*
 * Created by Hicham B.I.
 */

package test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@RestController
@RequestMapping("user")
public class UserController {

    @RequestMapping("/all")
    public Collection<User> getUsers() {
        return new ArrayList<User>(
                Arrays.asList(
                        new User(1, "Hei"),
                        new User(2, "BK-201")
                ));
    }
}