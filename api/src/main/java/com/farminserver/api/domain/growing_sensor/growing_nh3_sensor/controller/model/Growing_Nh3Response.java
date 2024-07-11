package com.farminserver.api.domain.growing_sensor.growing_nh3_sensor.controller.model;

public class Growing_Nh3Response {
    private String GrowingRoomNum;
    private double GrowingNh3Data;
    private String unit;
    private long timestamp;

    public Growing_Nh3Response(String growingRoomNum, double growingNh3Data, String unit, long timestamp) {
        this.GrowingRoomNum = growingRoomNum;
        this.GrowingNh3Data = growingNh3Data;
        this.unit = unit;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public String getGrowingRoomNum() {
        return GrowingRoomNum;
    }
    public void setBoarsBarnRoomNum(String GrowingRoomNum) {
        this.GrowingRoomNum = this.GrowingRoomNum;
    }

    public double getGrowingNh3Data() {
        return GrowingNh3Data;
    }
    public void setGrowingNh3Data(double growingNh3Data) {
        this.GrowingNh3Data = growingNh3Data ;
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
