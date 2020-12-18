package com.spring;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.spring")
public class AppConfig {

    @Bean
    public UserDetail userDetail() {
        return new UserDetail("Pradeep", "Balachandran");
    }

//
//
//    @Bean
//    public UserDetail userDetailAB() {
//        return new UserDetail("Aparna", "Balachandran");
//    }
}
