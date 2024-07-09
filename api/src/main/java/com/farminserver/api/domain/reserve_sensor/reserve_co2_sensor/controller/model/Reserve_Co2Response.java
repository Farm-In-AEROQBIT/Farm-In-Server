package com.farminserver.api.domain.reserve_sensor.reserve_co2_sensor.controller.model;

public class Reserve_Co2Response {
    private String reserveSowsRoomNum;
    private double ReserveCo2Data;
    private String unit;
    private long timestamp;

    public Reserve_Co2Response(String reserveSowsRoomNum, double reserveCo2, String unit, long timestamp) {
        this.reserveSowsRoomNum = reserveSowsRoomNum;
        this.ReserveCo2Data = reserveCo2;
        this.unit = unit;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public String getReserveBarnRoomNum() {
        return reserveSowsRoomNum;
    }
    public void setReserveBarnRoomNum(String reserveSowsRoomNum) {
        this.reserveSowsRoomNum = reserveSowsRoomNum;
    }

    public double getReserveCo2Data() {
        return ReserveCo2Data;
    }
    public void setReserveCo2(double reserveCo2) {
        this.ReserveCo2Data = reserveCo2;
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
