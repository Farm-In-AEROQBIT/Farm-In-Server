package com.farminserver.api.domain.admin.converter;

import com.farminserver.api.common.annotation.Converter;
import com.farminserver.db.admin.AdminEntity;
import com.farminserver.api.domain.admin.controller.model.AdminResponse;
import org.springframework.stereotype.Component;

@Component
@Converter
public class AdminConverter {
    public AdminResponse convertToResponse(AdminEntity admin) {
        if (admin == null) {
            return null;
        }

        return new AdminResponse(
                admin.getAdminId(), admin.getAdminPw()
        );
    }
}
