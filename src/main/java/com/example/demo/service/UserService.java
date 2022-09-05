package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user) throws Exception {
        Optional<User> existingUser = userRepository.findById(user.getNumber());
        if(existingUser.isPresent()) {
            throw new Exception("User is already registered");
        }
        String rawPass = user.getPassword();
        String encryptedPass = passwordEncoder.encode(rawPass);
        user.setPassword(encryptedPass);
        return userRepository.save(user);
    }
}
