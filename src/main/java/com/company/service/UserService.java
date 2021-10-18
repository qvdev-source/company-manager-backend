package com.company.service;

import com.company.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User addUser(User user);

    List<User> findAllUsers();

    User editUser(User user, long id);

    User findUserById(long id);

    void deleteUser(long id);

    User findByUsername(String username);

}

