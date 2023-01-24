package com.rest.api.service;

import com.rest.api.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User saveUser(User user);

    User getUserById(Long id);

    String deleteUserById(Long id);

    List<User> getAllUserByCourse(int course);

}
