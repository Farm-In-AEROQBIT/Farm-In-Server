package com.farminserver.api.domain.admin.controller.model;

public class AdminResponse {
    private Long adminId;
    private String adminPw;

    // Constructor for Long adminId and String adminPw
    public AdminResponse(Long adminId, String adminPw) {
        this.adminId = adminId;
        this.adminPw = adminPw;
    }

    // Constructor for error message (Optional)
    public AdminResponse(String message) {
        this.adminId = null; // or handle appropriately
        this.adminPw = message;
    }

    // Getters and Setters
    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getAdminPw() {
        return adminPw;
    }

    public void setAdminPw(String adminPw) {
        this.adminPw = adminPw;
    }
}
