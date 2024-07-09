package com.farminserver.api.domain.reserve_sensor.reserve_nh3_sensor.controller.model;

public class Reserve_Nh3Response {
    private String reserveRoomNum;
    private double ReserveNh3;
    private String unit;
    private long timestamp;

    public Reserve_Nh3Response(String reserveBarnRoomNum, double ReserveNh3, String unit, long timestamp) {
        this.reserveRoomNum = reserveBarnRoomNum;
        this.ReserveNh3 = ReserveNh3;
        this.unit = unit;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public String getReserveRoomNum() {
        return reserveRoomNum;
    }
    public void setReserveRoomNum(String reserveRoomNum) {
        this.reserveRoomNum = reserveRoomNum;
    }

    public double getReserveNh3Data() {
        return ReserveNh3;
    }
    public void setBoarsNh3Data(double reserveNh3) {
        this.ReserveNh3 = reserveNh3 ;
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
