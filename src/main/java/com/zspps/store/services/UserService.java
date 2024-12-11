package com.zspps.store.services;

import java.util.HashMap;
import java.util.List;
import com.zspps.store.libs.UserDataToGet;
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

    public HashMap<String, String> getUserData(String login)
    {
        HashMap<String, String> userData = new HashMap<String, String>();
        UserDataToGet data = userRepository.getUserDataByLogin(login);

        if(data == null)
        {
            throw new IllegalArgumentException("Пользователь не найден!");
        }

        userData.put("login", data.getLogin());
        userData.put("phoneNumber", data.getPhoneNumber());
        userData.put("email", data.getEmail());
        userData.put("firstName", data.getFirstName());
        userData.put("lastName", data.getLastName());
        userData.put("company", data.getCompany());

        return userData;
    }

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

    public boolean loginUser(String login, String password)
    {
        List<LoginData> loginDataList = userRepository.findDataToLogin();

        for (LoginData lg : loginDataList) {
            if (lg.getLogin().equals(login)) {
                String hashedPassword = Security.hashDataToSHA256(password);
                if (lg.getPassword().equals(hashedPassword)) {
                    return true;
                }
            }
        }
        return false;
    }
}
