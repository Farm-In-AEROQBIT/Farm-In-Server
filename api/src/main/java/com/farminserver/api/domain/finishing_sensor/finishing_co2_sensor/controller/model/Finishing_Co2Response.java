package com.farminserver.api.domain.boars_sensor.boars_co2_sensor.controller.model;

public class Finishing_Co2Response {
    private double co2;
    private String unit;
    private long timestamp;

    public Finishing_Co2Response(double co2, String unit, long timestamp) {
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
