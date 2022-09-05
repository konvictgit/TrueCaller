package com.example.demo.controller;

import com.example.demo.service.SpamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("spam")
public class SpamController {

    @Autowired
    private SpamService spamService;

    @PostMapping()
    public void markSpam(@RequestBody String number, Authentication authentication) throws Exception {
        String userNumber = authentication.getName();
        spamService.markSpam(number, userNumber);
    }

    @GetMapping("query/{number}")
    public long getSpamCount(@PathVariable("number") String number) {
        return spamService.getSpamCount(number);
    }
}
