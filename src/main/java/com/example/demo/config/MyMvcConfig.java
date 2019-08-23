package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@EnableWebMvc
//@EnableWebMvc表示从springboot中全面接管springboot对springMVC的配置，自动配置将不起作用，所有springMVC的配置将有我们自己手动配置。
//可以使用 WebMvcConfigurerAdapter 可以来扩展spring MVC 的功能。
//@Configuration
//public class MyMvcConfig extends WebMvcConfigurerAdapter {
    //Ctrl+o

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        //super.addViewControllers(registry);
//        //浏览器发送请求atyn,之后会跳转到success页面。
//        registry.addViewController("atyn").setViewName("success");
//    }
//}
