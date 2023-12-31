package com.example.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class ApplicatioinSecurityConfig  {

   protected void configure(HttpSecurity http) throws Exception{
       http
               .authorizeHttpRequests()
                .requestMatchers("/myAccount").authenticated()
                .requestMatchers("/details").permitAll();

   }
}
