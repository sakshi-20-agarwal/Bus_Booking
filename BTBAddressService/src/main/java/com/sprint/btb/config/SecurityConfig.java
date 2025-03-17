package com.sprint.btb.config;
 
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

import org.springframework.security.config.Customizer;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
 
@Configuration

@EnableWebSecurity

public class SecurityConfig {
 
	 @Bean

	 public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		 http

	     .csrf().disable()  

	     .authorizeHttpRequests(auth -> auth

	     .anyRequest().permitAll()

	      )

	     .httpBasic();
 
	      return http.build();
 
	    }

}

 