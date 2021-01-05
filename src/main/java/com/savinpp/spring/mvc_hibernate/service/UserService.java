package com.savinpp.spring.mvc_hibernate.service;

import com.savinpp.spring.mvc_hibernate.entity.Role;
import com.savinpp.spring.mvc_hibernate.entity.User;

import java.util.List;

public interface UserService {

    public Role getRoleByName(String name);
    public List<Role> listRoles();
    public List<User> index();
    public User show (int id);
    public void save (User user);
    public void update (User user);
    public void delete (User user);
    public User showUserByUsername(String username);
}
