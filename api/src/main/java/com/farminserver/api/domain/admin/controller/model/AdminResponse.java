package com.farminserver.api.domain.admin.controller.model;

public class AdminResponse {
    private String admin_id;
    private String admin_pw;

    public AdminResponse(String admin_id, String admin_pw) {
        this.admin_id = admin_id;
        this.admin_pw = admin_pw;
    }

    // 추가: 단일 인자 생성자
    public AdminResponse(String admin_id) {
        this.admin_id = admin_id;
    }

    // Getters and Setters
    public String getAdmin_id() {
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
