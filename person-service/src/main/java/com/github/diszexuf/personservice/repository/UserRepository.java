package com.github.diszexuf.personservice.repository;

import com.github.diszexuf.personservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
