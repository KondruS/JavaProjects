package com.example.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    String name;
    String username;
    String pwd;
    String group;
    String isValidated;


    public User(String s, String anj, String google) {
        this.name=s;
        this.username= anj;
        this.group=google;
    }
}
