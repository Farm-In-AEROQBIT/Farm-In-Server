package com.farminserver.api.domain.admin.service;

import com.farminserver.db.admin.AdminEntity;
import com.farminserver.api.domain.admin.business.AdminBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminBusiness business;

    public AdminEntity save(AdminEntity admin) {
        return business.save(admin);
    }

    public AdminEntity getById(String id) {
        return business.getById(id);
    }

    public List<AdminEntity> getAll() {
        return business.getAll();
    }

    public void deleteById(String id) {
        business.deleteById(id);
    }
}
