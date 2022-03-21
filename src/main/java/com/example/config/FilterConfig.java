package com.example.config;

import com.example.filter.HttpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        //FilterRegistrationBean实例 可以配置过滤器优先级
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();

        HttpFilter httpFilter = new HttpFilter();
        filterRegistrationBean.setFilter(httpFilter);
        filterRegistrationBean.setOrder(1);
        // /只会拦截路径 不会拦截页面  /*不仅拦截路径 也会拦截页面   /*的优先级比较高
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setName("HttpFilter");

        return filterRegistrationBean;
    }
}
