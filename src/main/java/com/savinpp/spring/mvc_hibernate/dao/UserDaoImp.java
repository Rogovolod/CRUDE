package com.savinpp.spring.mvc_hibernate.dao;

import com.savinpp.spring.mvc_hibernate.entity.Role;
import com.savinpp.spring.mvc_hibernate.entity.User;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = entityManager.createQuery("from User", User.class).getResultList();
        return allUsers;
    }

    @Override
    public void saveUser(User user) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(user);
    }

    @Override
    public void saveRole(Role role) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(role);
    }

    @Override
    public User getUser(int id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    public void deleteUser(User user) {
        entityManager.remove(user);
    }

    @Override
    public User showUserByUsername(String username) {
        return entityManager
                .createQuery("select u from User u where u.login =?1", User.class)
                .setParameter(1, username)
                .getSingleResult();
    }

    @Override
    public Role getRoleByName(String name) {
        return entityManager.createQuery("select role from Role role where role.role=:name", Role.class)
                .setParameter("name", name)
                .getSingleResult();

    }
    @Override
    public List<Role> listRoles() {
        Query query = entityManager.createQuery("from Role");
        return query.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public User show(int id) {
        return (entityManager.find(User.class, id));
    }


}