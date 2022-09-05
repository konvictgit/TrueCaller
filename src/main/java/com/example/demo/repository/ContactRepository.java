package com.example.demo.repository;

import com.example.demo.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    public List<Contact> findByNameContainingIgnoreCase(String text);

    public List<Contact> findByNumber(String contactNumber);

    public List<Contact> findByUser_Number(String userNumber);

    public Contact findOneByUser_NumberAndNumber(String userNumber, String contactNumber);
}
