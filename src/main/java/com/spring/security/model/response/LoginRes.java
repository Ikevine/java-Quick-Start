package com.spring.security.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder  // This will create instance of the class easy by using builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRes {

    private String email;
    private String token;
}
