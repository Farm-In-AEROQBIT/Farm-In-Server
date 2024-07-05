package com.farminserver.api.domain.boars_sensor.boars_co2_sensor.controller.model;

public class Boar_Co2Response {
    private String boarsBarnRoomNum;
    private double BoarsCo2Data;
    private String unit;
    private long timestamp;

    public Boar_Co2Response(String boarsBarnRoomNum, double boarsCo2, String unit, long timestamp) {
        this.boarsBarnRoomNum = boarsBarnRoomNum;
        this.BoarsCo2Data = boarsCo2;
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

    public double getBoarsCo2Data() {
        return BoarsCo2Data;
    }

    public void setBoarsCo2(double boarsCo2) {
        this.BoarsCo2Data = boarsCo2;
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
