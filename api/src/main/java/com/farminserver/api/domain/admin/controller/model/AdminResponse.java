package com.farminserver.api.domain.admin.controller.model;

import org.springframework.data.redis.connection.stream.StreamInfo;

public class AdminResponse {
    private String admin_id;
    private String admin_pw;

    public AdminResponse(String Admin_Id, String Admin_Pw) {
        this.admin_id = Admin_Id;
        this.admin_pw = Admin_Pw;
    }

    // Getters and Setters
    public String getadmin_id() {
        return admin_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_pw() {
        return admin_pw;
    }

    public void setAdmin_pw(String admin_pw) {
        this.admin_pw = admin_pw;
    }

}
