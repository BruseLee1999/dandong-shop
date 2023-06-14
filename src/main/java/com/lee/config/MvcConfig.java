package com.lee.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("video");
        registry.addViewController("/my-account-information.html").setViewName("my-account-information");
        registry.addViewController("/my-account-order.html").setViewName("my-account-order");
        registry.addViewController("/my-account-address.html").setViewName("my-account-address");
        registry.addViewController("/privacy.html").setViewName("privacy");
    }
}
