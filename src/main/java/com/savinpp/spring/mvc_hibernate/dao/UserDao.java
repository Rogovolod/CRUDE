package com.savinpp.spring.mvc_hibernate.dao;

import com.savinpp.spring.mvc_hibernate.entity.User;

import java.util.List;

public interface UserDao {
    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUser(int id);

    public void deleteUser(int id);
}
