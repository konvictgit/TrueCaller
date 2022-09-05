package com.example.demo.service;

import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String number) {
        com.example.demo.entity.User userInDb = userRepository.findById(number).get();
        if (userInDb == null) {
            throw new UsernameNotFoundException(number);
        }
        UserDetails userDetails = User.withUsername(userInDb.getNumber()).password(userInDb.getPassword()).authorities("USER").build();
        return userDetails;
    }
}
