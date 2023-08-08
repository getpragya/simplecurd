package com.simplecrud.simplecrud.domain.model;

public interface UserRepositoryCustom {
    User findUserByUsername(String username);
}