package com.farminserver.api.domain.admin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminApiController {

    private long adminId;
    private long adminPw;
    private long user_phone_num;
    private long farm_name;

    // Getters and Setters
    public long getAdminId() {
        return adminId;
    }

    public void setAdminId(long adminId) {
        this.adminId = adminId;
    }

    public long getAdminPw() {
        return adminPw;
    }

    public void setAdminPw(long adminPassword) {
        this.adminPw = adminPassword;
    }

    public long getUser_phone_num() {
        return user_phone_num;
    }
    public void setUser_phone_num(long userPhoneNum) {
        this.user_phone_num = userPhoneNum;
    }

    public long getFarm_name() {
        return farm_name;
    }
    public void setFarm_name(long farmName) {
        this.farm_name = farmName;
    }
}
