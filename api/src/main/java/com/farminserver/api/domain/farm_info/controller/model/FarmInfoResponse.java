package com.farminserver.api.domain.farm_info.controller.model;

public class FarmInfoResponse {
    private String user_phone_num;
    private String farm_name;

    public FarmInfoResponse(String User_Phone_Num, String Farm_Name) {
        this.user_phone_num = User_Phone_Num;
        this.farm_name = Farm_Name;
    }

    //Getter and Setters
    public String getUser_phone_num() {return user_phone_num;}
    public void setUser_phone_num(String user_phone_num) {this.user_phone_num = user_phone_num;}

    public String getFarm_name() {return farm_name;}
    public void setFarm_name(String farm_name) {this.farm_name = farm_name;}
}
