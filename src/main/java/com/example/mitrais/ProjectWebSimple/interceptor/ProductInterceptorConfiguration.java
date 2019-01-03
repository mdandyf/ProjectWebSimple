package com.example.mitrais.ProjectWebSimple.interceptor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

@Component
public class ProductInterceptorConfiguration extends WebMvcConfigurerAdapter{
    @Autowired
    private ProductInterceptor productInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(productInterceptor);
    }
}
