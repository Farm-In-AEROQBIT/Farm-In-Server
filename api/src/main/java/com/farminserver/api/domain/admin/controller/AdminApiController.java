package com.farminserver.api.domain.admin.controller;

import com.farminserver.api.domain.boars_sensor.boars_co2_sensor.business.Co2Business;
import com.farminserver.api.domain.boars_sensor.boars_co2_sensor.controller.model.Co2Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farminserver.db.admin.AdminEntity;
import com.farminserver.api.domain.admin.service.AdminService;
import com.farminserver.api.domain.admin.converter.AdminConverter;
import com.farminserver.api.domain.admin.controller.model.AdminResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import java.io.IOException;

@RestController
@RequestMapping("/api/admin")
public class AdminApiController {

    private String adminId;
    private String adminPassword;

    // Getters and Setters
    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

}
