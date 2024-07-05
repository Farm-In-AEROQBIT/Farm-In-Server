package com.farminserver.api.domain.maternity_sensor.maternity_humidity_sensor.controller.model;

public class Maternity_HumidityResponse {
    private String maternityRoomNum;
    private double maternityHumidityData;
    private String unit;
    private long timestamp;

    public Maternity_HumidityResponse(String maternityRoomNum, double maternityHumidity, String unit, long timestamp) {
        this.maternityRoomNum = maternityRoomNum;
        this.maternityHumidityData = maternityHumidity;
        this.unit = unit;
        this.timestamp = timestamp;
    }

    // Getters and Setters

    public String getMaternityRoomNum() {
        return maternityRoomNum;
    }
    public void setMaternityRoomNum(String maternityRoomNum) {
        this.maternityRoomNum = maternityRoomNum;
    }

    public double getMaternityHumidityData() {
        return maternityHumidityData;
    }
    public void setHumidity(double maternityHumidity) {
        this.maternityHumidityData = maternityHumidity;
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
