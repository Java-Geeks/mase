package io.github.javageeks.mase.service.test;

import io.github.javageeks.mase.model.User;
import io.github.javageeks.mase.service.UserService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/mase-core-context.xml"})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Ignore
    @Test
    public void testTodoService() {

        //create a user for test
        User user = new User();
        user.setFirstName("Foo");
        user.setLastName("Bar");
        user.setEmail("foo@bar.org");
        user.setPassword("foobar");
        user = userService.saveOrUpdate(user);

        assertNotNull(user);
        assertEquals("Foo", user.getFirstName());
        assertEquals("Bar", user.getLastName());
        assertEquals("foo@bar.org", user.getEmail());
        assertEquals("foobar", user.getPassword());

    }

}