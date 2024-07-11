package com.farminserver.api.domain.piglet_sensor.piglet_temperature_sensor.controller.model;

public class Piglet_TemperatureResponse {
    private String pigletBarnRoomNum;
    private double PigletTemperatureData;
    private String unit;
    private long timestamp;
    private long pigletTemperatureLocateData;

    public Piglet_TemperatureResponse(String pigletBarnRoomNum, double pigletTemperatureData, String unit, long timestamp, long pigletTemperatureLocateData) {
        this.pigletBarnRoomNum = pigletBarnRoomNum;
        this.PigletTemperatureData = pigletTemperatureData;
        this.unit = unit;
        this.timestamp = timestamp;
        this.pigletTemperatureLocateData = pigletTemperatureLocateData;
    }

    // Getters and Setters

    public String getPigletRoomNum() {
        return pigletBarnRoomNum;
    }
    public void setPigletRoomNum(String pigletRoomNum) {
        this.pigletBarnRoomNum = pigletRoomNum;
    }

    public double getPigletTemperatureData() {
        return PigletTemperatureData;
    }
    public void setPigletTemperatureData(double pigletTemperatureData) {
        this.PigletTemperatureData = pigletTemperatureData;
    }

    public long getpigletTemperatureLocateData() {
        return pigletTemperatureLocateData;
    }
    public void setPigletTemperatureLocateData(long TemperatureLocateData) {
        this.pigletTemperatureLocateData = TemperatureLocateData;
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
