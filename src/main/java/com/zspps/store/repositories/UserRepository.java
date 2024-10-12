package com.zspps.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zspps.store.models.User;

public interface UserRepository extends JpaRepository<User, Long> {}