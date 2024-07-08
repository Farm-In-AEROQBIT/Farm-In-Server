package com.farminserver.api.domain.boars_sensor.boars_nh3_sensor.controller.model;

public class Maternity_Nh3Response {
    private String boarsBarnRoomNum;
    private double BoarsNh3;
    private String unit;
    private long timestamp;

    public Maternity_Nh3Response(String boarsBarnRoomNum, double boarsnh3, String unit, long timestamp) {
        this.boarsBarnRoomNum = boarsBarnRoomNum;
        this.BoarsNh3 = boarsnh3;
        this.unit = unit;
        this.timestamp = timestamp;
    }

    // Getters and Setters

    public String getBoarsBarnRoomNum() {
        return boarsBarnRoomNum;
    }
    public void setBoarsBarnRoomNum(String boarsBarnRoomNum) {
        this.boarsBarnRoomNum = boarsBarnRoomNum;
    }

    public double getBoarsNh3Data() {
        return BoarsNh3;
    }
    public void setBoarsNh3Data(double boarsNh3) {
        this.BoarsNh3 = boarsNh3 ;
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