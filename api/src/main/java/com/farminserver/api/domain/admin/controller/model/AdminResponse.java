package com.farminserver.api.domain.admin.controller.model;

public class AdminResponse {
    private String admin_id;
    private String admin_pw;
    private String user_phone_num;
    private String farm_name;

    public AdminResponse(String Admin_Id, String Admin_Pw, String User_Phone_Num, String Farm_Name) {
        this.admin_id = Admin_Id;
        this.admin_pw = Admin_Pw;
        this.user_phone_num = User_Phone_Num;
        this.farm_name = Farm_Name;
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

    public String getUser_phone_Num() {
        return user_phone_num;
    }
    public void setUser_phone_num(String user_phone_num) {
        this.user_phone_num = user_phone_num;
    }

    public String getFarm_Name() {
        return farm_name;
    }

    public void setFarm_Name(String farm_Name) {
        this.farm_name = farm_Name;
    }

}
