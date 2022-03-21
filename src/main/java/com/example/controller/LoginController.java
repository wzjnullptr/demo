package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {

    @GetMapping("/login")
    public List<String> login(){
        List<String> arrs = new ArrayList<>();
        arrs.add("1");
        arrs.add("2");
        return arrs;
    }
}
