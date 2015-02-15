/*
 * Created by Hicham B.I.
 */

package test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("user")
public class UserController {
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/all")
    public Collection<User> test(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new ArrayList<User>(
                Arrays.asList(
                        new User(counter.incrementAndGet(), "Hei"),
                        new User(counter.incrementAndGet(), "BK-201")
                ));
    }
}