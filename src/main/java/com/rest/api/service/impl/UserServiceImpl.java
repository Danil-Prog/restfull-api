package com.rest.api.service.impl;


import com.rest.api.entity.User;
import com.rest.api.exception.BadRequestException;
import com.rest.api.repository.UserRepository;
import com.rest.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new BadRequestException("User id not found")
        );
    }

    @Override
    public String deleteUserById(Long id) {
        userRepository.deleteById(id);
        return "User deleted!";
    }

    @Override
    public List<User> getAllUserByCourse(int course) {
        return userRepository.findAllByCourse(course);
    }
}
