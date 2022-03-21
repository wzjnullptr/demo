package com.example.filter;

import com.example.config.HttpRequestConfig;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;;
import java.io.IOException;

@Component
@Order(1)
@WebFilter(filterName = "HttpFilter", urlPatterns = "/*")
public class HttpFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try{
            ServletRequest requestWapper =  null;
            //拦截所有HttpservletRequest 类型的请求 修改为自定义的servletRequest  网页请求为httpServletRequest请求 servletRequest可以处理其他形式过来的请求
            if(servletRequest instanceof HttpServletRequest) {
                requestWapper = new HttpRequestConfig((HttpServletRequest) servletRequest);
            }
            if(requestWapper == null){
                filterChain.doFilter(servletRequest,servletResponse);
            } else {
                filterChain.doFilter(requestWapper, servletResponse);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {

    }
}
