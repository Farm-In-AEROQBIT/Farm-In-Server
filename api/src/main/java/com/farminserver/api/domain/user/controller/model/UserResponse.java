package com.farminserver.api.domain.user.controller.model;

public class UserResponse {
    private String user_id;
    private String user_pw;
    private String user_phone_num;
    private String user_name;
    private String farm_name;
    private String message;

    public UserResponse(String user_id, String user_pw, String user_phone_num, String user_name, String farm_name) {
        this.user_id = user_id;
        this.user_pw = user_pw;
        this.user_phone_num = user_phone_num;
        this.user_name = user_name;
        this.farm_name = farm_name;
    }

    // Error message constructor
    public UserResponse(String message) {
        this.message = message;
    }

    // Getters and Setters
    public String getUserId() { return user_id; }
    public void setUserId(String user_id) { this.user_id = user_id; }

    public String getUserPw() { return user_pw; }
    public void setUserPw(String user_pw) { this.user_pw = user_pw; }

    public String getUserPhoneNum() { return user_phone_num; }
    public void setUserPhoneNum(String user_phone_num) { this.user_phone_num = user_phone_num; }

    public String getUserName() { return user_name; }
    public void setUserName(String user_name) { this.user_name = user_name; }

    public String getFarmName() { return farm_name; }
    public void setFarmName(String farm_name) { this.farm_name = farm_name; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
