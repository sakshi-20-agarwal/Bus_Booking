package com.sprint.btb.config;

import com.sprint.btb.service.CustomerDetailsService;
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

	private CustomerDetailsService customerDetailsService;

//	public SecurityConfig(CustomerDetailsService customerDetailsService) {
//		this.customerDetailsService = customerDetailsService;
//	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(customerDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf(customizer -> customizer.disable())
				.authorizeRequests(request -> request
						.requestMatchers("/api/customers/create", "/api/customers/login", "/api/customers/exists/**")
						.permitAll()
//                        .anyRequest().authenticated() 
						.anyRequest().permitAll())
				.formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults())
				.authenticationProvider(daoAuthenticationProvider()).build();
	}
}
