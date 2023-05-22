package com.larramendi.springboot.security;

import com.larramendi.springboot.entities.User;
import com.larramendi.springboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User savedUser = userRepository.findByEmail(userName);

        if(userName != null) {
            return new org.springframework.security.core.userdetails.User(savedUser.getEmail(), savedUser.getPassword(),
                    savedUser.getRoles().stream()
                            .map((role) -> new SimpleGrantedAuthority(role.getName())).toList());
        }
        else {
            throw new UsernameNotFoundException("Invalid email or password");
        }

    }
}
