package com.farminserver.api.domain.admin.service;

import com.farminserver.api.common.error.TokenErrorCode;
import com.farminserver.api.util.Jwt.JwtUtil;
import com.farminserver.api.util.PassWord.PasswordValidator;
import com.farminserver.api.domain.admin.business.AdminBusiness;
import com.farminserver.db.admin.AdminEntity;
import com.farminserver.db.user.UserEntity;
import com.farminserver.db.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminBusiness business;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    public AdminEntity save(AdminEntity admin) {
        return business.save(admin);
    }

    public AdminEntity getById(Long id) {
        return business.getById(id);
    }

    public List<AdminEntity> getAll() {
        return business.getAll();
    }

    public void deleteById(Long id) {
        business.deleteById(id);
    }

    public boolean authenticateAdmin(AdminEntity adminEntity) {
        AdminEntity admin = business.getById(adminEntity.getAdminId());
        if (admin != null) {
            String storedPassword = admin.getAdminPw();
            String providedPassword = adminEntity.getAdminPw();
            return storedPassword.equals(providedPassword) && PasswordValidator.containsSpecialCharacter(providedPassword);
        }
        return false;
    }

    public boolean isAuthorized(String token, String role) {
        Optional<TokenErrorCode> tokenError = jwtUtil.validateToken(token);
        if (tokenError.isPresent()) {
            return false;
        }
        String tokenRole = jwtUtil.extractRole(token);
        return tokenRole.equals(role) || tokenRole.equals("ADMIN");
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> getUserById(Long userId) {
        return userRepository.findById(userId);
    }
}
