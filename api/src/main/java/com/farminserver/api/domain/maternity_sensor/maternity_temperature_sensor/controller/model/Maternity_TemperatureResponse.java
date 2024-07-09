package com.farminserver.api.domain.maternity_sensor.maternity_temperature_sensor.controller.model;

public class Maternity_TemperatureResponse {
    private String maternityRoomNum;
    private double MaternityTemperatureData;
    private String unit;
    private long timestamp;
    private long maternityTemperatureLocateData;

    public Maternity_TemperatureResponse(String maternityBarnRoomNum, double maternityTemperatureData, String unit, long timestamp, long maternityTemperatureLocateData) {
        this.maternityRoomNum = maternityBarnRoomNum;
        this.MaternityTemperatureData = maternityTemperatureData;
        this.unit = unit;
        this.timestamp = timestamp;
        this.maternityTemperatureLocateData = maternityTemperatureLocateData;
    }

    // Getters and Setters

    public String getMaternityRoomNum() {
        return maternityRoomNum;
    }
    public void setMaternityRoomNum(String maternityRoomNum) {
        this.maternityRoomNum = maternityRoomNum;
    }

    public double getMaternityTemperatureData() {
        return MaternityTemperatureData;
    }
    public void setMaternityTemperatureData(double maternityTemperatureData) {
        this.MaternityTemperatureData = maternityTemperatureData;
    }

    public long getmaternityTemperatureLocateData() {
        return maternityTemperatureLocateData;
    }
    public void setmaternityTemperatureLocateData(long boarsTemperatureLocateData) {
        this.maternityTemperatureLocateData = boarsTemperatureLocateData;
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
