package com.farminserver.api.domain.admin.business;

import com.farminserver.db.admin.AdminEntity;
import com.farminserver.db.admin.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.farminserver.api.common.annotation.Business;

import java.util.List;

@Business
@Component
public class AdminBusiness {

    @Autowired
    private AdminRepository adminRepository;

    public AdminEntity save(AdminEntity admin) {
        return adminRepository.save(admin);
    }

    public AdminEntity getById(String id) {
        return adminRepository.findById(id).orElse(null);
    }

    public List<AdminEntity> getAll() {
        return adminRepository.findAll();
    }

    public void deleteById(String id) {
        adminRepository.deleteById(id);
    }
}
