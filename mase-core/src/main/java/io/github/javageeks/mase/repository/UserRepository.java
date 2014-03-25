package io.github.javageeks.mase.repository;

import io.github.javageeks.mase.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Interface for todo repository.
 */
public interface UserRepository extends MongoRepository<User, String> {

    /**
     * Find user by id.
     * @param id the user id
     * @return the user with the given id or null if no user found
     */
    User findById(String id);

    /**
     * Find user by email.
     * @param email the user email
     * @return the user with the given email or null if no user found
     */
    List<User> findByEmail(String email);

    /**
     * Find user by email and password.
     * @param email the user email
     * @param password the user password
     * @return the user with the given email/password or null if no user found
     */
    User findByEmailAndPassword(String email, String password);

}
