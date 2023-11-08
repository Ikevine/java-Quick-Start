package com.spring.security.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class User {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
