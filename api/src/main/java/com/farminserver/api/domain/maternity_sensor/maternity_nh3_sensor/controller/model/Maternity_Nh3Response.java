package com.farminserver.api.domain.maternity_sensor.maternity_nh3_sensor.controller.model;

public class Maternity_Nh3Response {
    private String MaternityRoomNum;
    private double MaternityNh3;
    private String unit;
    private long timestamp;

    public Maternity_Nh3Response(String maternityRoomNum, double maternityNh3, String unit, long timestamp) {
        this.MaternityRoomNum = maternityRoomNum;
        this.MaternityNh3 = maternityNh3;
        this.unit = unit;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public String getMaternityRoomNum() {
        return MaternityRoomNum;
    }
    public void setMaternityRoomNum(String maternityRoomNum) {
        this.MaternityRoomNum = maternityRoomNum;
    }

    public double getMaternityNh3Data() {
        return MaternityNh3;
    }
    public void setMaternityNh3Data(double maternityNh3) {
        this.MaternityNh3 = maternityNh3 ;
    }

    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }

    public long getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}