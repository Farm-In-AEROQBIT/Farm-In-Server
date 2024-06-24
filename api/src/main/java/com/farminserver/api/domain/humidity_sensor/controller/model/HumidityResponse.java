package com.farminserver.api.domain.humidity_sensor.controller.model;

public class HumidityResponse {
    private double humidity;
    private String unit;
    private long timestamp;

    public HumidityResponse(double humidity, String unit, long timestamp) {
        this.humidity = humidity;
        this.unit = unit;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
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
