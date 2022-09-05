package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class Contact {

    @Id
    @GeneratedValue
    private long contactId;

    @Column(length = 50)
    private String name;

    @Column(length = 10, nullable = false)
    private String number;

    @ManyToOne
    @JoinColumn(name = "user_number")
    private User user;

    public Contact() {
    }

    public Contact(String name, String number, User user) {
        this.name = name;
        this.number = number;
        this.user = user;
    }

    public long getContactId() {
        return contactId;
    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
