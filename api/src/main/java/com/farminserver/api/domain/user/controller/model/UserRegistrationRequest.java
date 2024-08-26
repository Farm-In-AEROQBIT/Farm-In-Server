package com.farminserver.api.domain.user.controller.model;

public class UserRegistrationRequest {
    private String userId;
    private String userPw;
    private String userName;
    private String userPhoneNum;
    private Long farmName; // FarmInfoEntity와 연결될 ID (선택사항)

    // Getters and Setters
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUserPw() {
        return userPw;
    }
    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserPhoneNum() {
        return userPhoneNum;
    }
    public void setUserPhoneNum(String userPhoneNum) {
        this.userPhoneNum = userPhoneNum;
    }
    public Long getFarmName() {
        return farmName;
    }
    public void setFarmName(Long farmName) {
        this.farmName = farmName;
    }
}
