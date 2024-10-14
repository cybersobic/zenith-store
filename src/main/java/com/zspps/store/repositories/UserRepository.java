package com.zspps.store.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zspps.store.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u.login FROM User u")
    List<String> findAllLogins();
}