package com.example.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

//重写 request的getRemoteUser方法
public class HttpRequestConfig extends HttpServletRequestWrapper {
    public HttpRequestConfig(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getRemoteUser(){
        String username = "admin";
        return username;
    }
}
