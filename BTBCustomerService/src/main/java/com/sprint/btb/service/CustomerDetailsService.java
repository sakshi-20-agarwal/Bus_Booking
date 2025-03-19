package com.sprint.btb.service;

import com.sprint.btb.entity.CustomerEntity;
import com.sprint.btb.repo.CustomerRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private CustomerRepository customerRepository;

//    public CustomerDetailsService(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        CustomerEntity customer = customerRepository.findByEmail(email);

        if (customer == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }

        // Return a Spring Security User object (this is where we map CustomerEntity to UserDetails)
        return User.builder()
                .username(customer.getEmail()) // Email is the username
                .password(customer.getPassword()) // Password from the database (already encoded)
                .roles("USER") // You can dynamically assign roles here based on your requirement
                .build();
    }
}
