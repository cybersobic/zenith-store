package com.zspps.store.services;

import java.util.List;
import java.util.Map;
import com.zspps.store.libs.UserDataToGet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zspps.store.libs.LoginData;
import com.zspps.store.libs.Security;
import com.zspps.store.models.User;
import com.zspps.store.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Map<String, String> getUserData(String login) {
        UserDataToGet data = userRepository.getUserDataByLogin(login);

        if(data == null) {
            throw new IllegalArgumentException("Пользователь не найден!");
        }

        return Map.of(
            "login", data.getLogin(),
            "phoneNumber", data.getPhoneNumber(),
            "email", data.getEmail(),
            "firstName", data.getFirstName(),
            "lastName", data.getLastName(),
            "company", data.getCompany()
        );
    }

    public void registerUser(User user) {
        if(checkLogins(user.getLogin()) && checkPhoneNumbers(user.getPhoneNumber()) && checkEmails(user.getEmail())) {
            String hashedPassword = Security.hashDataToSHA256(user.getPassword());
            user.setPassword(hashedPassword);
            userRepository.save(user);
        }
    }

    public boolean checkLogins(String login) {
        List<String> logins = userRepository.findAllLogins();

        for(String lg : logins) {
            if(lg.equals(login)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkPhoneNumbers(String phoneNumber) {
        List<String> phoneNumbers = userRepository.findAllPhoneNumbers();

        for(String pn : phoneNumbers) {
            if(pn.equals(phoneNumber)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkEmails(String email) {
        List<String> emails = userRepository.findAllEmails();

        for(String em : emails) {
            if(em.equals(email)) {
                return false;
            }
        }
        return true;
    }

    public boolean loginUser(String login, String password) {
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
