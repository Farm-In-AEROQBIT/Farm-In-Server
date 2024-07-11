package com.farminserver.api.domain.finishing_sensor.finishing_humidity_sensor.controller.model;

public class Finishing_HumidityResponse {
    private String finishingBarnRoomNum;
    private double FinishingHumidityData;
    private String unit;
    private long timestamp;

    public Finishing_HumidityResponse(String finishingBarnRoomNum, double FinishingHumidityData, String unit, long timestamp) {
        this.finishingBarnRoomNum = finishingBarnRoomNum;
        this.FinishingHumidityData = FinishingHumidityData;
        this.unit = unit;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public String getFinishingBarnRoomNum() {
        return finishingBarnRoomNum;
    }
    public void setFinishingBarnRoomNum(String finishingBarnRoomNum) {
        this.finishingBarnRoomNum = finishingBarnRoomNum;
    }

    public double getFinishingHumidityData() {
        return FinishingHumidityData;
    }
    public void setSensorValue(double finishingHumidityData) {
        this.FinishingHumidityData = finishingHumidityData;
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
