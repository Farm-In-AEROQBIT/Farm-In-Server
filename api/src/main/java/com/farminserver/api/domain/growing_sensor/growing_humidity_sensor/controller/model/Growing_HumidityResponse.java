package com.farminserver.api.domain.growing_sensor.growing_humidity_sensor.controller.model;

public class Growing_HumidityResponse {
    private String GrowingBarnRoomNum;
    private double GrowingHumidityData;
    private String unit;
    private long timestamp;

    public Growing_HumidityResponse(String growingBarnRoomNum, double growingHumidityData, String unit, long timestamp) {
        this.GrowingBarnRoomNum = growingBarnRoomNum;
        this.GrowingHumidityData = growingHumidityData;
        this.unit = unit;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public String getGrowingBarnRoomNum() {
        return getGrowingBarnRoomNum();
    }
    public void setGrowingBarnRoomNum(String growingBarnRoomNum) {
        this.GrowingBarnRoomNum = growingBarnRoomNum;
    }

    public double getGrowingHumidityData() {
        return GrowingHumidityData;
    }
    public void setGrowingHumidityData(double growingHumidityData) {
        this.GrowingHumidityData = growingHumidityData;
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
