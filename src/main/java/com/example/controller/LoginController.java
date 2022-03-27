package com.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/login")
@Api(tags = "LoginController",description = "登录Controller")
public class LoginController {

    @GetMapping("/login")
    @ApiOperation("登录方法")
    public List<String> login(){
        List<String> arrs = new ArrayList<>();
        arrs.add("1");
        arrs.add("2");
        return arrs;
    }
}
