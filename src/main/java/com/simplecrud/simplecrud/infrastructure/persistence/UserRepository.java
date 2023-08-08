package com.simplecrud.simplecrud.infrastructure.persistence;


import com.simplecrud.simplecrud.domain.model.User;
import com.simplecrud.simplecrud.domain.model.UserRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
    Optional<User> findByUsername(String username);
}