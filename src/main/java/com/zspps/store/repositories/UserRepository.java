// Интерфейс-репозиторий для пользователя

package com.zspps.store.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.zspps.store.libs.LoginData;
import com.zspps.store.models.User;

public interface UserRepository extends JpaRepository<User, Long> 
{
    // Выборка всех логинов из БД
    @Query("SELECT u.login FROM User u")
    List<String> findAllLogins();

    // Выборка всех номеров телефонов из БД
    @Query("SELECT u.phone_number FROM User u")
    List<String> findAllPhoneNumbers();

    // Выборка всех электронных почт из БД
    @Query("SELECT u.email FROM User u")
    List<String> findAllEmails();

    // Выборка всех наборов логина и пароля из БД
    @Query("SELECT new com.zspps.store.libs.LoginData(u.login, u.password) FROM User u")
    List<LoginData> findDataToLogin();
}