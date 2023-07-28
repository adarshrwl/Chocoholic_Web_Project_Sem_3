package com.example.chocoholic.service;

import com.example.chocoholic.entity.UserDetail;
import com.example.chocoholic.entity.User;
import com.example.chocoholic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user=userRepository.findByEmail(email);
        user.orElseThrow(()->new UsernameNotFoundException("User Not Found"));
        return user.map(UserDetail::new).get();
    }
}
