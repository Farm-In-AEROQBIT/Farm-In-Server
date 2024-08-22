package com.farminserver.api.domain.user.controller.model;

public class UserResponse {
    private String userId;
    private String userPw;
    private String userPhoneNum;
    private String userName;
    private String farmName;
    private String role;
    private String message;

    // 필요한 모든 필드를 포함하는 생성자
    public UserResponse(String userId, String userPw, String userPhoneNum, String userName, String farmName, String role) {
        this.userId = userId;
        this.userPw = userPw;
        this.userPhoneNum = userPhoneNum;
        this.userName = userName;
        this.farmName = farmName;
        this.role = role;
    }

    // Error message constructor
    public UserResponse(String message) {
        this.message = message;
    }

    // Getters and Setters
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getUserPw() { return userPw; }
    public void setUserPw(String userPw) { this.userPw = userPw; }

    public String getUserPhoneNum() { return userPhoneNum; }
    public void setUserPhoneNum(String userPhoneNum) { this.userPhoneNum = userPhoneNum; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getFarmName() { return farmName; }  // farmName 필드의 Getter
    public void setFarmName(String farmName) { this.farmName = farmName; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
