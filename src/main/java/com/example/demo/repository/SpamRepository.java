package com.example.demo.repository;

import com.example.demo.entity.Spam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpamRepository extends JpaRepository<Spam, String> {

    public Optional<Spam> findByMarkedBy_NumberAndNumber(String markedByNumber, String number);

    public long countByNumber(String number);
}
