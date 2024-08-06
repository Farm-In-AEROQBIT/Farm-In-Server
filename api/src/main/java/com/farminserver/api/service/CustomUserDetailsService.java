package com.farminserver.api.service;

import com.farminserver.db.user.UserEntity;
import com.farminserver.db.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with userId: " + userId));

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUserId())
                .password(user.getUserPw())
                .roles("USER")
                .build();
    }
}
