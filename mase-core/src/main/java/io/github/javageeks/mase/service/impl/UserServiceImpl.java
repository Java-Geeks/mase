package io.github.javageeks.mase.service.impl;

import io.github.javageeks.mase.model.User;
import io.github.javageeks.mase.repository.UserRepository;
import io.github.javageeks.mase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * User business service implementation.
 */
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User saveOrUpdate(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

}
