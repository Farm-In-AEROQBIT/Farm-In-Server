package com.farminserver.api.domain.finishing_sensor.finishing_co2_sensor.controller.model;

public class Finishing_Co2Response {
    private String finishingBarnRoomNum;
    private double FinishingCo2Data;
    private String unit;
    private long timestamp;

    public Finishing_Co2Response(String finishingBarnRoomNum, double finishingCo2Data, String unit, long timestamp) {
        this.finishingBarnRoomNum = finishingBarnRoomNum;
        this.FinishingCo2Data = finishingCo2Data;
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

    public double getFinishingCo2Data() {
        return FinishingCo2Data;
    }
    public void setSensorValue(double finishingCo2Data) {
        this.FinishingCo2Data = finishingCo2Data;
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
