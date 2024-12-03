package com.zspps.store.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zspps.store.libs.LoginData;
import com.zspps.store.libs.Security;
import com.zspps.store.models.User;
import com.zspps.store.repositories.UserRepository;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    public void registerUser(User user)
    {
        if(checkLogins(user.getLogin()) && 
        checkPhoneNumbers(user.getPhoneNumber()) && 
        checkEmails(user.getEmail())) 
        {
            String hashedPassword = Security.hashDataToSHA256(user.getPassword());
            user.setPassword(hashedPassword);
            userRepository.save(user);
        }
    }

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

    public boolean loginUser(User user)
    {
        List<LoginData> loginData = userRepository.findDataToLogin();
        String login = user.getLogin();
        String password = user.getPassword();

        for (LoginData lg : loginData) 
        {
            if (lg.getLogin().equals(login)) 
            {
                String hashedPassword = Security.hashDataToSHA256(password);
                if (lg.getPassword().equals(hashedPassword)) 
                {
                    return true;
                }
            }
        }
        return false;
    }
}
