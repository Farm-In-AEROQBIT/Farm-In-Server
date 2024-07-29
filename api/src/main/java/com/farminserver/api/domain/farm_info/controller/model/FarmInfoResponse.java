package com.farminserver.api.domain.farm_info.controller.model;

public class FarmInfoResponse {
    private String farm_name;

    public FarmInfoResponse(String Farm_Name) {
        this.farm_name = Farm_Name;
    }

    //Getter and Setters
    public String getFarm_name() {return farm_name;}
    public void setFarm_name(String farm_name) {this.farm_name = farm_name;}
}
