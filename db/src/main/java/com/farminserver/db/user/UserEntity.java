package com.farminserver.db.user;

import com.farminserver.db.farm_info.FarmInfoEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import com.farminserver.db.BaseEntity;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {

    private String userId;
    private String userPw;
    private String userName;
    private String userPhoneNum;

    @ManyToOne
    @JoinColumn(name = "farm_info_id")
    @JsonBackReference
    private FarmInfoEntity farmInfo;

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

    public FarmInfoEntity getFarmInfo() {
        return farmInfo;
    }

    public void setFarmInfo(FarmInfoEntity farmInfo) {
        this.farmInfo = farmInfo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
