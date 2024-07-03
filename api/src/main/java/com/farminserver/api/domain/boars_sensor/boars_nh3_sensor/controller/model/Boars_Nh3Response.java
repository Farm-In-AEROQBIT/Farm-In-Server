package com.farminserver.api.domain.boars_sensor.boars_nh3_sensor.controller.model;

public class Boars_Nh3Response {
    private double nh3;
    private String unit;
    private long timestamp;

    public Boars_Nh3Response(double nh3, String unit, long timestamp) {
        this.nh3 = nh3;
        this.unit = unit;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public double getNh3() {
        return nh3;
    }

    public void setNh3(double nh3) {
        this.nh3 = nh3;
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