package com.example.demo.controller;

import com.example.demo.dto.SearchResponseDto;
import com.example.demo.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("number/{searchNum}")
    public List<SearchResponseDto> searchByNumber(@PathVariable("searchNum") String searchNum, Authentication authentication) {
        String userNumber = authentication.getName();
        return searchService.searchByNumber(searchNum, userNumber);
    }

    @GetMapping("name/{searchText}")
    public List<SearchResponseDto> searchByName(@PathVariable("searchText") String searchText) {
        return searchService.searchByName(searchText);
    }
}
