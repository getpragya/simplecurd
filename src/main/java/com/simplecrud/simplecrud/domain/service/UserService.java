package com.simplecrud.simplecrud.domain.service;

import com.simplecrud.simplecrud.domain.exceptions.UserAlreadyExistsException;
import com.simplecrud.simplecrud.domain.exceptions.UserNotFoundException;
import com.simplecrud.simplecrud.domain.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User createUser(User user) throws UserAlreadyExistsException;

    User getUserById(Long id) throws UserNotFoundException;

    User updateUser(Long id, User updatedUser) throws UserNotFoundException;

    boolean deleteUser(Long id) throws UserNotFoundException;
}
