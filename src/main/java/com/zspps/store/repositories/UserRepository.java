package com.zspps.store.repositories;

import java.util.HashMap;
import java.util.List;

import com.zspps.store.libs.UserDataToGet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.zspps.store.libs.LoginData;
import com.zspps.store.models.User;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> 
{
    @Query("SELECT u.login FROM User u")
    List<String> findAllLogins();

    @Query("SELECT u.phoneNumber FROM User u")
    List<String> findAllPhoneNumbers();

    @Query("SELECT u.email FROM User u")
    List<String> findAllEmails();

    @Query("SELECT new com.zspps.store.libs.LoginData(u.login, u.password) FROM User u")
    List<LoginData> findDataToLogin();

    @Query("SELECT new com.zspps.store.libs.UserDataToGet(u.login, u.phoneNumber, u.email, u.firstName, u.lastName, u.company) " +
            "FROM User u WHERE u.login = :login")
    UserDataToGet getUserDataByLogin(@Param("login") String login);
}