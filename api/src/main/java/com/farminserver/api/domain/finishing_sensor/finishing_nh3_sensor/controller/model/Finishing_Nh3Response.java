package com.farminserver.api.domain.finishing_sensor.finishing_nh3_sensor.controller.model;

public class Finishing_Nh3Response {
    private String finishingBarnRoomNum;
    private double FinishingNh3Data;
    private String unit;
    private long timestamp;

    public Finishing_Nh3Response(String finishingBarnRoomNum, double FinishingNh3data, String unit, long timestamp) {
        this.finishingBarnRoomNum = finishingBarnRoomNum;
        this.FinishingNh3Data = FinishingNh3data;
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

    public double getFinishingNh3Data() {
        return FinishingNh3Data;
    }
    public void setSensorValue(double FinishingNh3) {
        this.FinishingNh3Data = FinishingNh3;
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
