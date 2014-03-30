package io.github.javageeks.mase.service;

import io.github.javageeks.mase.model.User;

import java.util.List;

/**
 * User business service interface.
 */
public interface UserService {

    /**
     * save or update a user.
     * @param user the user to save or update
     * @return the created or updated user
     */
    User saveOrUpdate(User user);

    /**
     * Delete a user.
     * @param user the user to delete
     */
    void delete(User user);

    /**
     * Find a user by its Id.
     * @param id the user id
     * @return the user with the given id or null if no user found with the given id
     */
    User findById(String id);

    /**
     * Find a user by email and password.
     * @param email the user email
     * @return the user with the given email or null if no user found
     */
    User findByEmail(String email);

    /**
     * Find a user by email and password.
     * @param email the user email
     * @param password the user password
     * @return the user with the given email and password or null if no user found
     */
    User findByEmailAndPassword(String email, String password);
    
    /**
     * Find all users
     * 
     * @return all users
     */
    List<User> findAll();

}
