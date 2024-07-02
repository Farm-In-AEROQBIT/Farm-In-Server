package com.farminserver.api.domain.admin.business;

import com.farminserver.db.admin.AdminEntity;
import com.farminserver.db.admin.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.farminserver.api.common.annotation.Business;
import lombok.RequiredArgsConstructor;
import com.farminserver.api.domain.admin.controller.AdminApiController;
import com.farminserver.api.domain.admin.controller.model.AdminResponse;
import com.farminserver.api.domain.admin.converter.AdminConverter;
import com.farminserver.api.domain.admin.service.AdminService;

import java.util.List;

@Business
@Component
public class AdminBusiness {

    @Autowired
    private AdminRepository repository;

    public AdminEntity save(AdminEntity admin) {
        return repository.save(admin);
    }

    public AdminEntity getById(String id) {
        return repository.findById(id).orElse(null);
    }

    public List<AdminEntity> getAll() {
        return repository.findAll();
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
