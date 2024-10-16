package com.zspps.store.repositories;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zspps.store.models.User;
import com.zspps.store.libs.LoginData;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u.login FROM User u")
    List<String> findAllLogins();

    @Query("SELECT new com.zspps.store.libs.LoginData(u.login, u.password) FROM User u")
    List<LoginData> findDataToLogin();
}