package com.farminserver.db.user;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    Optional<UserEntity> findById(String usersId);
    Optional<UserEntity> findByRole(String role);
}
