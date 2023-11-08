package com.spring.security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth/v1")
public class User {

//    @ResponseBody is used to send the return value of method to the functin
    //directly
    @GetMapping
    public String hellow(){
        System.out.println("Hellow people");
        return "hellow";
    }
}
