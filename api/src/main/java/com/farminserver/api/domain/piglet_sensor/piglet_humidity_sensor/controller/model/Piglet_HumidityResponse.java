package com.farminserver.api.domain.piglet_sensor.piglet_humidity_sensor.controller.model;

public class Piglet_HumidityResponse {
    private String pigletRoomNum;
    private double PigletHumidityData;
    private String unit;
    private long timestamp;

    public Piglet_HumidityResponse(String pigletRoomNum, double pigletHumidity, String unit, long timestamp) {
        this.pigletRoomNum = pigletRoomNum;
        this.PigletHumidityData = pigletHumidity;
        this.unit = unit;
        this.timestamp = timestamp;
    }

    // Getters and Setters

    public String getPigletRoomNum() {
        return pigletRoomNum;
    }
    public void setPigletRoomNum(String pigletRoomNum) {
        this.pigletRoomNum = pigletRoomNum;
    }

    public double getPigletHumidityData() {
        return PigletHumidityData;
    }
    public void setHumidity(double pigletHumidity) {
        this.PigletHumidityData = pigletHumidity;
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
