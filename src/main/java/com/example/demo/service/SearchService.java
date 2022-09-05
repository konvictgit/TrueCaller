package com.example.demo.service;

import com.example.demo.dto.SearchResponseDto;
import com.example.demo.entity.Contact;
import com.example.demo.entity.User;
import com.example.demo.repository.ContactRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.SpamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SearchService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private SpamRepository spamRepository;

    public List<SearchResponseDto> searchByNumber(String searchNum, String userNumber) {
        List<SearchResponseDto> searchResults = searchInExistingUsers(searchNum, userNumber);
        if(!searchResults.isEmpty()) {
            return searchResults;
        }
        searchResults = getResultInContacts(searchNum);
        return searchResults;
    }

    private List<SearchResponseDto> searchInExistingUsers(String searchNum, String userNumber) {
        Optional<User> existingUser = userRepository.findById(searchNum);
        if (existingUser.isEmpty())
            return new ArrayList<>();
        User existingUserData = existingUser.get();
        SearchResponseDto searchResponseDto = new SearchResponseDto();
        searchResponseDto.setNumber(existingUserData.getNumber());
        searchResponseDto.setName(existingUserData.getName());

        Contact contact = contactRepository.findOneByUser_NumberAndNumber(searchNum, userNumber);
        if (contact != null) {
            searchResponseDto.setEmail(existingUserData.getEmail());
        }
        return List.of(searchResponseDto);
    }

    private List<SearchResponseDto> getResultInContacts(String searchNum) {
        List<SearchResponseDto> results = new ArrayList<>();
        List<Contact> contacts = contactRepository.findByNumber(searchNum);
        long spamCount = spamRepository.countByNumber(searchNum);
        for(Contact c:contacts) {
            SearchResponseDto dto = new SearchResponseDto();
            dto.setName(c.getName());
            dto.setNumber(c.getNumber());

            results.add(dto);
        }
        return results;
    }

    public List<SearchResponseDto> searchByName(String searchText) {
        List<SearchResponseDto> results = new ArrayList<>();
        List<User> matchingUsers = userRepository.findByNameContainingIgnoreCase(searchText);
        for(User u:matchingUsers) {
            SearchResponseDto dto = new SearchResponseDto();
            dto.setNumber(u.getNumber());
            dto.setName(u.getName());
            results.add(dto);
        }
        List<Contact> matchingContacts = contactRepository.findByNameContainingIgnoreCase(searchText);
        for(Contact c:matchingContacts) {
            SearchResponseDto dto = new SearchResponseDto();
            dto.setNumber(c.getNumber());
            dto.setName(c.getName());
            results.add(dto);
        }
        return results;
    }
}
