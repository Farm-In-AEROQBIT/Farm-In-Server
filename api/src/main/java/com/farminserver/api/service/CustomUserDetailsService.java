package com.farminserver.api.service;

import com.farminserver.db.user.UserEntity;
import com.farminserver.db.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        // 데이터베이스에서 사용자 정보 조회
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with userId: " + userId));

        // UserDetails 객체 생성 및 반환
        return User.builder()
                .username(user.getUserId())
                .password(user.getUserPw()) // 비밀번호는 암호화된 상태로 저장되어야 합니다.
                .roles("USER") // 역할을 적절히 설정합니다. 필요에 따라 ADMIN 등을 추가할 수 있습니다.
                .build();
    }
}
