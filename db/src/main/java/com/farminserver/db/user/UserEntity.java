package com.farminserver.db.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    private String userId;
    private String userPw;
    private String userName;
    private String userPhoneNum;
    private String farm_name;

    // Getter and Setters
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getUserPw() { return userPw; }
    public void setUserPw(String userPw) { this.userPw = userPw; }

    public String getUser_phone_num() { return userPhoneNum; }
    public void setUser_phone_num(String userPhoneNum) { this.userPhoneNum = userPhoneNum; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getFarm_name() { return farm_name; }
    public void setFarm_name(String farm_name) { this.farm_name = farm_name; }
}
