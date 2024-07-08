package com.farminserver.api.domain.boars_sensor.boars_nh3_sensor.controller.model;

public class Boars_Nh3Response {
    private String boarsBarnRoomNum;
    private double BoarsNh3;
    private String unit;
    private long timestamp;

    public Maternity_PmResponse(double co2, String unit, long timestamp) {
        this.co2 = co2;
        this.unit = unit;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public double getCo2() {
        return co2;
    }

    public void setSensorValue(double co2) {
        this.co2 = co2;
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