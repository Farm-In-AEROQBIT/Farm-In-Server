package com.farminserver.api.domain.boars_sensor.boars_temperature_sensor.controller.model;

public class TemperatureResponse {
    private double temperature;
    private String unit;
    private long timestamp;

    public TemperatureResponse(double temperature, String unit, long timestamp) {
        this.temperature = temperature;
        this.unit = unit;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
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
