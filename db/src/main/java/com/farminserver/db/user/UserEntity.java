package com.farminserver.db.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import com.farminserver.db.BaseEntity;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    private String userId;
    private String userPw;
    private String userName;
    private String userPhoneNum;
    private String farmName;
    private String role;

    // 기본 생성자
    public UserEntity() {
    }

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

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
