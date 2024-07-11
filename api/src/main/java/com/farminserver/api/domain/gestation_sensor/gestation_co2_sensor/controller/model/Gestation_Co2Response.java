package com.farminserver.api.domain.gestation_sensor.gestation_co2_sensor.controller.model;

public class Gestation_Co2Response {
    private String gestationBarnRoomNum;
    private double GestationCo2Data;
    private String unit;
    private long timestamp;

    public Gestation_Co2Response(String gestationBarnRoomNum, double GestationCo2Data, String unit, long timestamp) {
        this.gestationBarnRoomNum = gestationBarnRoomNum;
        this.GestationCo2Data = GestationCo2Data;
        this.unit = unit;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public String getGestationBarnRoomNum() {
        return gestationBarnRoomNum;
    }
    public void setGestationBarnRoomNum(String gestationBarnRoomNum) {
        this.gestationBarnRoomNum = gestationBarnRoomNum;
    }

    public double getGestationCo2Data() {
        return GestationCo2Data;
    }
    public void setGestationCo2Data(double GestationCo2) {
        this.GestationCo2Data = GestationCo2;
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
