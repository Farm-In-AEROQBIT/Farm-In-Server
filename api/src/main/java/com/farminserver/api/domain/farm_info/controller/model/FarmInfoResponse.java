package com.farminserver.api.domain.farm_info.controller.model;

public class FarmInfoResponse {
    private String farmName;

    public FarmInfoResponse(String farmName) {
        this.farmName = farmName;
    }

    // Getters and Setters
    public String getFarmName() { return farmName; }
    public void setFarmName(String farmName) { this.farmName = farmName; }
}
