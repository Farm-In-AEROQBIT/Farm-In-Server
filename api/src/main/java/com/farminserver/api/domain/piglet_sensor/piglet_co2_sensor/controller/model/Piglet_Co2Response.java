package com.farminserver.api.domain.piglet_sensor.piglet_co2_sensor.controller.model;

public class Piglet_Co2Response {
    private String pigletRoomNum;
    private double PigletCo2Data;
    private String unit;
    private long timestamp;

    public Piglet_Co2Response(String pigletRoomNum, double pigletCo2, String unit, long timestamp) {
        this.pigletRoomNum = pigletRoomNum;
        this.PigletCo2Data = pigletCo2;
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

    public double getPigletCo2Data() {
        return PigletCo2Data;
    }

    public void setPigletCo2(double pigletCo2) {
        this.PigletCo2Data = pigletCo2;
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
