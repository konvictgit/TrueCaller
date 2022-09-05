package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "reg_user")
public class User {

    @Id
    @Column(length = 10)
    private String number;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(length = 50, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    public User() {
    }

    public User(String number, String name, String email, String password) {
        this.number = number;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}




