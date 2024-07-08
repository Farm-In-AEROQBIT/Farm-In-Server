package com.farminserver.api.domain.gestation_sensor.gestation_nh3_sensor.controller.model;

public class Gestation_Nh3Response {
    private String gestationBarnRoomNum;
    private double GestationNh3;
    private String unit;
    private long timestamp;

    public Gestation_Nh3Response(String gestationBarnRoomNum, double gestationNh3, String unit, long timestamp) {
        this.gestationBarnRoomNum = gestationBarnRoomNum;
        this.GestationNh3 = gestationNh3;
        this.unit = unit;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public String getGestationBarnRoomNum() {
        return gestationBarnRoomNum;
    }
    public void setGestationBarnRoomNum(String gestationBarnRoomNum) {
        this.gestationBarnRoomNum = gestationBarnRoomNum;
    }

    public double getGestationNh3() {
        return GestationNh3;
    }
    public void setGestationNh3Data(double gestationNh3) {
        this.GestationNh3 = GestationNh3 ;
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
