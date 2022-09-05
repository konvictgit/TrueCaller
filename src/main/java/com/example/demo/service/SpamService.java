package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.entity.Spam;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.SpamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class SpamService {

    @Autowired
    private SpamRepository spamRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void markSpam(String number, String userNumber) throws Exception {
        Optional<User> user = userRepository.findById(userNumber);
        if(user.isEmpty()) {
            throw new Exception("Please register to mark this number as spam");
        }
        Optional<Spam> existingSpam = spamRepository.findByMarkedBy_NumberAndNumber(userNumber, number);
        if(existingSpam.isPresent()) {
            throw new Exception("This has been already marked spam by you");
        }
        Spam spam = new Spam(number, user.get());
        spamRepository.save(spam);
    }

    public long getSpamCount(String number) {
        return spamRepository.countByNumber(number);
    }
}
