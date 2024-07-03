package com.farminserver.api.domain.boars_sensor.boars_co2_sensor.controller.model;

public class Boars_Co2Response {
    private double BoarsCo2;
    private String unit;
    private long timestamp;

    public Boars_Co2Response(double BoarsCo2, String unit, long timestamp) {
        this.BoarsCo2 = BoarsCo2;
        this.unit = unit;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public double getBoarsCo2() {
        return BoarsCo2;
    }

    public void setBoarsCo2(double BoarsCo2) {
        this.BoarsCo2 = BoarsCo2;
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