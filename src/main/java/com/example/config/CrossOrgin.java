package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrossOrgin {

    //设置全局跨域配置
    @Bean
    public WebMvcConfigurer coreOrgin(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        //放行全部原始头信息
                        .allowedHeaders("*")
                        //允许所有请求方法跨域调用
                        .allowedMethods("*")
                        //允许所有域名进行跨域调用
                        .allowedOrigins("*");
            }
        };
    }
}
