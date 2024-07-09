package com.farminserver.api.domain.reserve_sensor.reserve_humidity_sensor.controller.model;

public class Reserve_HumidityResponse {
    private String reserveBarnRoomNum;
    private double ReserveHumidityData;
    private String unit;
    private long timestamp;

    public Reserve_HumidityResponse(String reserveBarnRoomNum, double reserveHumidity, String unit, long timestamp) {
        this.reserveBarnRoomNum = reserveBarnRoomNum;
        this.ReserveHumidityData = reserveHumidity;
        this.unit = unit;
        this.timestamp = timestamp;
    }

    // Getters and Setters

    public String getReserveSowsRoomNum() {
        return reserveBarnRoomNum;
    }
    public void setReserveSowsRoomNum(String reserveBarnRoomNum) {
        this.reserveBarnRoomNum = reserveBarnRoomNum;
    }

    public double getReserveHumidityData() {
        return ReserveHumidityData;
    }
    public void setReserveHumidityData(double ReserveHumidity) {
        this.ReserveHumidityData = ReserveHumidity;
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
