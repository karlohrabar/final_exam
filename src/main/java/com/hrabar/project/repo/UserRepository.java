package com.hrabar.project.repo;

import com.hrabar.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User,UUID> {

    User findByEmail(String email);
}
