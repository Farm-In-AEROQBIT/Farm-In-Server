package com.farminserver.api.domain.boars_sensor.boars_humidity_sensor.controller.model;

public class Boars_HumidityResponse {
    private String boarsBarnRoomNum;
    private double BoarsHumidityData;
    private String unit;
    private long timestamp;

    public Boars_HumidityResponse(String boarsBarnRoomNum, double boarsHumidity, String unit, long timestamp) {
        this.boarsBarnRoomNum = boarsBarnRoomNum;
        this.BoarsHumidityData = boarsHumidity;
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

    public double getBoarsHumidityData() {
        return BoarsHumidityData;
    }
    public void setHumidity(double boarsHumidity) {
        this.BoarsHumidityData = boarsHumidity;
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
