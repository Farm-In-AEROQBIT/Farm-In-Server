package com.farminserver.db.admin;

import com.farminserver.db.admin.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminEntity, String> {
}