package com.example.demo.dao;

import com.example.demo.model.Role;
import com.example.demo.model.User ;
import org.springframework.stereotype.Repository;

import jakarta.persistence.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> listUsers() {
        return em.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public User getUserById(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public void saveOrUpdateUser(User user) {
        if (user.getId() == null || user.getId() <= 0) {
            em.persist(user);
        } else {
            em.merge(user);
        }
    }

    @Override
    public void deleteUserById(Long id) {
        em.createQuery("DELETE FROM User WHERE id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public User getUserByUsername(String username) {
        try {
            User user = em.createQuery(
                    "SELECT u FROM User u LEFT JOIN FETCH u.roles WHERE u.username = :username",
                    User.class
            ).setParameter("username", username).getSingleResult();

            System.out.println("🔍 DAO загрузил роли: " + user.getRoles());
            return user;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Role getRoleByName(String name) {
        try {
            return em.createQuery("SELECT r FROM Role r WHERE r.name = :name", Role.class)
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public void saveRole(Role role) {
        em.persist(role);
    }
}




