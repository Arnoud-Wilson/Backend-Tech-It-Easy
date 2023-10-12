package com.Novi.TechItEasy.repositories;

import com.Novi.TechItEasy.models.security.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, String> {
}

