package com.simplecrud.simplecrud.infrastructure.persistence;

import com.simplecrud.simplecrud.domain.model.User;
import com.simplecrud.simplecrud.domain.model.UserRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
public class UserRepositoryCustomImpl implements UserRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User findUserByUsername(String username) {
        return entityManager
                .createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
                .setParameter("username", username)
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);
    }
}
