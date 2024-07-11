package com.farminserver.api.domain.user.controller;

import com.farminserver.api.domain.user.business.UserBusiness;
import com.farminserver.api.domain.user.controller.model.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

    private String userId;
    private String userPw;
    private String userName;
    private String userPhoneNum;
    private String farmName;

    // Getter and Setter
    public String getUserId(){return userId;}
    public void setUserId(String userId){this.userId = userId;}

    public String getUserPw(){return userPw;}
    public void setUserPw(String userPw){this.userPw = userPw;}

    public String getUserName(){return userName;}
    public void setUserName(String userName){this.userName = userName;}

    public String getUserPhoneNum(){return userPhoneNum;}
    public void setUserPhoneNum(String userPhoneNum){this.userPhoneNum = userPhoneNum;}

    public String getFarmName(){return farmName;}
    public void setFarmName(String farmName){this.farmName = farmName;}
}
