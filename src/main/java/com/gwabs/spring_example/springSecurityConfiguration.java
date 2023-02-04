package com.gwabs.spring_example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.*;

@Configuration
public class springSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

         //1) Ensure All request are authenticated
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );
         //2) if a request is not auth, a web page is shown

        http.httpBasic(withDefaults());
         // disable CSRF -> POST, PUT
        http.csrf().disable();
        return http.build();
    }
}
