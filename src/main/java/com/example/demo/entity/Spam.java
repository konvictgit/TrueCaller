package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class Spam {

    @Id
    @GeneratedValue
    private long spamId;

    @Column(length = 10, nullable = false)
    private String number;

    @ManyToOne
    @JoinColumn(name = "user_number", nullable = false)
    private User markedBy;

    public Spam() {
    }

    public Spam(String number, User markedBy) {
        this.number = number;
        this.markedBy = markedBy;
    }

    public long getSpamId() {
        return spamId;
    }

    public void setSpamId(long spamId) {
        this.spamId = spamId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public User getMarkedBy() {
        return markedBy;
    }

    public void setMarkedBy(User markedBy) {
        this.markedBy = markedBy;
    }
}
