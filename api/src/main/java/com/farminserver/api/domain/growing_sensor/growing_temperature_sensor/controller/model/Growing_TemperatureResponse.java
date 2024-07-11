package com.farminserver.api.domain.growing_sensor.growing_temperature_sensor.controller.model;

public class Growing_TemperatureResponse {
    private String GrowingRoomNum;
    private double GrowingTemperatureData;
    private String unit;
    private long timestamp;
    private long GrowingTemperatureLocateData;

    public Growing_TemperatureResponse(String growingRoomNum, double growingtemperaturedata, String unit, long timestamp, long growingTemperatureLocateData) {
        this.GrowingRoomNum = growingRoomNum;
        this.GrowingTemperatureData = growingtemperaturedata;
        this.unit = unit;
        this.timestamp = timestamp;
        this.GrowingTemperatureLocateData = growingTemperatureLocateData;
    }

    // Getters and Setters
    public String getGrowingRoomNum() {
        return getGrowingRoomNum();
    }
    public void setGrowingRoomNum(String growingRoomNum) {
        this.GrowingRoomNum = growingRoomNum;
    }

    public double getGrowingTemperatureData() {
        return GrowingTemperatureData;
    }
    public void setGrowingTemperatureData(double growingTemperatureData) {
        this.GrowingTemperatureData = growingTemperatureData;
    }

    public long getGrowingTemperatureLocateData() {
        return GrowingTemperatureLocateData;
    }
    public void setGrowingTemperatureLocateData(long growingTemperatureLocateData) {
        this.GrowingTemperatureData = growingTemperatureLocateData;
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
