package com.farminserver.api.domain.reserve_sensor.reserve_nh3_sensor.controller.model;

public class Reserve_Nh3Response {
    private String reserveSowsRoomNum;
    private double ReserveNh3;
    private String unit;
    private long timestamp;

    public Reserve_Nh3Response(String reserveSowsRoomNum, double ReserveNh3, String unit, long timestamp) {
        this.reserveSowsRoomNum = reserveSowsRoomNum;
        this.ReserveNh3 = ReserveNh3;
        this.unit = unit;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public String getReserveSowsRoomNum() {
        return reserveSowsRoomNum;
    }
    public void setReserveSowsRoomNum(String reserveSowsRoomNum) {
        this.reserveSowsRoomNum = reserveSowsRoomNum;
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
