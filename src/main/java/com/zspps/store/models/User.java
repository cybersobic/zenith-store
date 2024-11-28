package com.zspps.store.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login", length = 24)
    private String login;

    @Column(name = "password", length = 64)
    private String password;

    @Column(name = "phone_number", length = 15)
    private String phoneNumber;

    @Column(name = "email", length = 320)
    private String email;

    @Column(name = "first_name", length = 35)
    private String firstName;

    @Column(name = "last_name", length = 35)
    private String lastName;

    @Column(name = "company", length = 50)
    private String company;

    public void setLogin(String login) 
    {
        this.login = login;
    }

    public String getLogin() 
    {
        return login;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }

    public void setPhoneNumber(String phone_number) 
    {
        this.phoneNumber = phone_number;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setFirstName(String first_name) 
    {
        this.firstName = first_name;
    }

    public String getFirstName() 
    {
        return firstName;
    }

    public void setLastName(String last_name) 
    {
        this.lastName = last_name;
    }

    public String getLastName() 
    {
        return lastName;
    }

    public void setCompany(String company) 
    {
        this.company = company;
    }
    
    public String getCompany() 
    {
        return company;
    }
}
