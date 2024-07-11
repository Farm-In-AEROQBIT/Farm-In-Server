package com.farminserver.api.domain.gestation_sensor.gestation_humidity_sensor.controller.model;

public class Gestation_HumidityResponse {
    private String gestationBarnRoomNum;
    private double GestationHumidityData;
    private String unit;
    private long timestamp;

    public Gestation_HumidityResponse(String gestationBarnRoomNum, double gestationHumidity, String unit, long timestamp) {
        this.gestationBarnRoomNum = gestationBarnRoomNum;
        this.GestationHumidityData = gestationHumidity;
        this.unit = unit;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public String getGestationBarnRoomNum() {
        return gestationBarnRoomNum;
    }
    public void setGestationBarnRoomNum(String GestationBarnRoomNum) {
        this.gestationBarnRoomNum = GestationBarnRoomNum;
    }

    public double getGestationHumidityData() {
        return GestationHumidityData;
    }
    public void setHumidity(double gestationHumidity) {
        this.GestationHumidityData = gestationHumidity;
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
