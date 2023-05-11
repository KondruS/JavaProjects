package com.epam.prac.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PracController {

    @GetMapping("/")
    public ResponseEntity<String> getData(){
        return new ResponseEntity<>("Data", HttpStatus.OK);
    }
}

