package com.farminserver.api.domain.finishing_sensor.finishing_temperature_sensor.controller.model;

public class Finishing_TemperatureResponse {
    private String finishingBarnRoomNum;
    private double FinishingTemperData;
    private String unit;
    private long timestamp;
    private long finishingTemperLocateData;

    public Finishing_TemperatureResponse(String finishingBarnRoomNum, double finishingTemperData, String unit, long timestamp, long finishingTemperLocateData) {
        this.finishingBarnRoomNum = finishingBarnRoomNum;
        this.FinishingTemperData = finishingTemperData;
        this.unit = unit;
        this.timestamp = timestamp;
        this.finishingTemperLocateData = finishingTemperLocateData;
    }

    // Getters and Setters
    public String getFinishingBarnRoomNum() {
        return finishingBarnRoomNum;
    }
    public void setFinishingBarnRoomNum(String finishingBarnRoomNum) {
        this.finishingBarnRoomNum = finishingBarnRoomNum;
    }

    public double getFinishingTemperData() {
        return FinishingTemperData;
    }
    public void setFinishingTemperData(double finishingTemperData) {
        this.FinishingTemperData = finishingTemperData;
    }

    public long getFinishingTemperLocateData() {
        return finishingTemperLocateData;
    }
    public void setFinishingTemperLocateData(long finishingTemperLocateData) {
        this.finishingTemperLocateData = finishingTemperLocateData;
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
