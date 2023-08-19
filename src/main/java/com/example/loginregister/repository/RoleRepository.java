package com.example.loginregister.repository;

import com.example.loginregister.entity.ERole;
import com.example.loginregister.entity.Role;
import com.example.loginregister.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<User, String> {
    Optional<Role> findByName(ERole name);
}
