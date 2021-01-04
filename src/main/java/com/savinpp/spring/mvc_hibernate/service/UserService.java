package com.savinpp.spring.mvc_hibernate.service;

import com.savinpp.spring.mvc_hibernate.entity.Role;
import com.savinpp.spring.mvc_hibernate.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();
    public void saveUser(User user);
    public User getUser(int id);
    public void deleteUser(User user);
    public User showUserByUsername(String username);
    public Role getRoleByName(String name);
    public List<Role> listRoles();
    public User show (int id);
}
