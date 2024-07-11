package com.farminserver.api.domain.growing_sensor.growing_co2_sensor.controller.model;

public class Growing_Co2Response {
    private String GrowingBarnRoomNum;
    private double GrowingCo2Data;
    private String unit;
    private long timestamp;

    public Growing_Co2Response(String growingBarnRoomNum, double growingCo2Data, String unit, long timestamp) {
        this.GrowingBarnRoomNum = growingBarnRoomNum;
        this.GrowingCo2Data = growingCo2Data;
        this.unit = unit;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public String getGrowingBarnRoomNum() {
        return GrowingBarnRoomNum;
    }
    public void setGrowingBarnRoomNum(String growingBarnRoomNum) {
        this.GrowingBarnRoomNum = growingBarnRoomNum;
    }

    public double getGrowingCo2Data() {
        return GrowingCo2Data;
    }
    public void setGrowingCo2Data(double growingCo2Data) {
        this.GrowingCo2Data = growingCo2Data;
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
