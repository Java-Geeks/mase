package io.github.javageeks.mase.web;

import io.github.javageeks.mase.model.User;
import io.github.javageeks.mase.service.UserService;
import io.github.javageeks.mase.web.util.SessionData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * User web controller.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SessionData sessionData;

    /*
    **********************
    * Create account
    **********************
    */

    @RequestMapping(value = "/account" , method = RequestMethod.POST)
    public @ResponseBody
    User registerNewAccount(@RequestBody User user) {

        if (userService.findByEmail(user.getEmail()) != null) {
            //user exists, TODO : return error status code
            return null;
        }

        user = userService.saveOrUpdate(user);
        sessionData.setUser(user);

        return user;
    }

    /*
    **********************
    * Update account
    **********************
    */

    @RequestMapping(value = "/account", method = RequestMethod.PUT)
    public @ResponseBody
    User updateAccount(@RequestBody User user) {

        user = userService.saveOrUpdate(user);
        sessionData.setUser(user);

        return user;

    }

    /*
    **********************
    * Account details
    **********************
    */

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public @ResponseBody
    User showAccountDetails() {
        return sessionData.getUser();
    }

    /*
    **********************
    * Delete Account
    **********************
    */

    @RequestMapping(value = "/account", method = RequestMethod.DELETE)
    public void deleteAccount(HttpSession session) {
        userService.delete(sessionData.getUser());
        sessionData.setUser(null);
        session.invalidate();
    }

    /*
    **********************
    * Login user
    **********************
    */

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(@RequestParam String email, @RequestParam  String password) {
        User user = userService.findByEmailAndPassword(email, password);
        if (user == null) {
            //no user found, TODO : return status code
            return;
        }
        sessionData.setUser(user);
    }

}