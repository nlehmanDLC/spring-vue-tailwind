package com.nlehman.vuetailwind.repositories;

import com.nlehman.vuetailwind.entities.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
