package com.lulu.project.Login.Config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lulu.project.Login.Filter.JWTFilter;


@Configuration
public class FilterConfig {
	
    @Bean
    public FilterRegistrationBean jwtFilter() {
        FilterRegistrationBean filter= new FilterRegistrationBean();
        filter.setFilter(new JWTFilter());
        // provide endpoints which needs to be restricted.
        // All Endpoints would be restricted if unspecified
       filter.addUrlPatterns("/api/v1/blog/restricted","/api1/login/user","/api1/login/adduser");
    return filter;
    }

}
