package com.farminserver.api.domain.user.service;

import com.farminserver.db.user.UserEntity;
import com.farminserver.db.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getUsersByRole(String role) {
        return userRepository.findByRole(role);
    }

    public UserEntity getUserById(String userId) {
        return userRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("User not found with userId: " + userId));
    }

    public List<UserEntity> getAllUsers() {
        // 현재 인증된 사용자의 역할을 확인
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            String role = userDetails.getAuthorities().iterator().next().getAuthority();

            // 역할이 "ROLE_ADMIN"인 경우 모든 사용자 정보를 반환
            if (role.equals("ROLE_ADMIN")) {
                return userRepository.findAll();
            }
        }
        throw new RuntimeException("Access denied");
    }
}
