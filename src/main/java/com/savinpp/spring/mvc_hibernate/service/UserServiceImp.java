package com.savinpp.spring.mvc_hibernate.service;

import com.savinpp.spring.mvc_hibernate.dao.UserDao;
import com.savinpp.spring.mvc_hibernate.entity.Role;
import com.savinpp.spring.mvc_hibernate.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImp implements UserService, UserDetailsService {

    @PersistenceContext
    private EntityManager entityManager;


    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @javax.transaction.Transactional
    public Role getRoleByName(String name) {
        return userDao.getRoleByName(name);
    }
    @Override
    @Transactional
    public List<Role> listRoles() {
        return userDao.listRoles();
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<User> index() {
        return userDao.index();
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public User show (int id) {
        return (entityManager.find(User.class,id));
    }

    @Override
    @org.springframework.transaction.annotation.Transactional
    public void save (User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }

    @Override
    @org.springframework.transaction.annotation.Transactional
    public void update (User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.update(user);
    }

    @Override
    @org.springframework.transaction.annotation.Transactional
    public void delete (User user) {
        entityManager.remove(entityManager.find(User.class,user.getId()));
    }
    @Override
    public User showUserByUsername(String username) {
        return userDao.showUserByUsername(username);
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly=true)
    public UserDetails loadUserByUsername (String a) throws UsernameNotFoundException {
        User user = userDao.showUserByUsername(a);
        System.out.println(user);
        if (user == null) {
            throw new UsernameNotFoundException("Пользователь не найден.");
        }
        return user;
    }
}
