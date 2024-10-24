// Класс-сервис с бизнес-логикой для User

package com.zspps.store.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zspps.store.libs.Security;
import com.zspps.store.models.LoginData;
import com.zspps.store.models.User;
import com.zspps.store.repositories.UserRepository;

@Service
public class UserService
{
    // Инициализация зависимости UserRepository
    @Autowired
    private UserRepository userRepository;

    // Метод регистрации пользователя на сайте
    public void registerUser(User user)
    {
        if(checkLogins(user.getLogin()) && 
        checkPhoneNumbers(user.getPhoneNumber()) && 
        checkEmails(user.getEmail())) 
        {
            String hashedPassword = Security.getHashData(user.getPassword());
            user.setPassword(hashedPassword);
            userRepository.save(user);
        }
    }

    // Проверка на существование логина при регистрации
    public boolean checkLogins(String login) 
    {
        List<String> logins = userRepository.findAllLogins();
        for(String lg : logins) 
        {
            if(lg.equals(login)) 
            {
                return false;
            }
        }
        return true;
    }

    // Проверка на существование номера телефона при регистрации
    public boolean checkPhoneNumbers(String phoneNumber) 
    {
        List<String> phoneNumbers = userRepository.findAllPhoneNumbers();
        for(String pn : phoneNumbers) 
        {
            if(pn.equals(phoneNumber)) 
            {
                return false;
            }
        }
        return true;
    }

    // Проверка на существование почты при регистрации
    public boolean checkEmails(String email) 
    {
        List<String> emails = userRepository.findAllEmails();
        for(String em : emails)
        {
            if(em.equals(email)) 
            {
                return false;
            }
        }
        return true;
    }

    // Метод авторизации пользователя на сайте
    public boolean loginUser(User user)
    {
        List<LoginData> loginData = userRepository.findDataToLogin();
        String login = user.getLogin();
        String password = user.getPassword();

        for (LoginData lg : loginData) 
        {
            if (lg.getLogin().equals(login)) 
            {
                String hashedPassword = Security.getHashData(password);
                if (lg.getPassword().equals(hashedPassword)) 
                {
                    return true;
                }
            }
        }
        return false;
    }
}
