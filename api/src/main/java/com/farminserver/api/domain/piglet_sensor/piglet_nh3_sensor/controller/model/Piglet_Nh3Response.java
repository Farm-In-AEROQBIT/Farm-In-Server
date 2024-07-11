package com.farminserver.api.domain.piglet_sensor.piglet_nh3_sensor.controller.model;

public class Piglet_Nh3Response {
    private String pigletRoomNum;
    private double PigletNh3;
    private String unit;
    private long timestamp;

    public Piglet_Nh3Response(String pigletRoomNum, double pigletNh3Data, String unit, long timestamp) {
        this.pigletRoomNum = pigletRoomNum;
        this.PigletNh3 = pigletNh3Data;
        this.unit = unit;
        this.timestamp = timestamp;
    }

    // Getters and Setters

    public String getPiglet_RoomNum() {
        return pigletRoomNum;
    }
    public void setPiglet_RoomNum(String pigletRoomNum) {
        this.pigletRoomNum = pigletRoomNum;
    }

    public double getPigletNh3Data() {
        return PigletNh3;
    }
    public void setPigletNh3Data(double pigletNh3) {
        this.PigletNh3 = pigletNh3 ;
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