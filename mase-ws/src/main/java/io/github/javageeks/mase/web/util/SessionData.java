package io.github.javageeks.mase.web.util;

import io.github.javageeks.mase.model.User;

import java.io.Serializable;

/**
 * A bean holding session data.
 */
public class SessionData implements Serializable {

    /**
     * The logged user.
     */
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}