package com.example.service;

import com.example.dao.UserDao;
import com.example.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getCurrentUser() {
        return userDao.selectCurrentUser();
    }
}
