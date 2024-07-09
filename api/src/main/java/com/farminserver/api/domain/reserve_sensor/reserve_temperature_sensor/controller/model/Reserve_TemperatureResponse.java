package com.farminserver.api.domain.reserve_sensor.reserve_temperature_sensor.controller.model;

public class Reserve_TemperatureResponse {
    private String reserveRoomNum;
    private double ReserveTemperatureData;
    private String unit;
    private long timestamp;
    private long reserveTemperatureLocateData;

    public Reserve_TemperatureResponse(String reserveRoomNum, double reserveTemperatureData, String unit, long timestamp, long reserveTemperatureLocateData) {
        this.reserveRoomNum = reserveRoomNum;
        this.ReserveTemperatureData = reserveTemperatureData;
        this.unit = unit;
        this.timestamp = timestamp;
        this.reserveTemperatureLocateData = reserveTemperatureLocateData;
    }

    // Getters and Setters
    public String getReserveRoomNum() {
        return reserveRoomNum;
    }
    public void setReserveRoomNum(String reserveRoomNum) {
        this.reserveRoomNum = reserveRoomNum;
    }

    public double getReserveTemperatureData() {
        return ReserveTemperatureData;
    }
    public void setReserveTemperatureData(double reserveTemperatureData) {
        this.ReserveTemperatureData = reserveTemperatureData;
    }

    public long getReserveTemperatureLocateData() {
        return reserveTemperatureLocateData;
    }
    public void setReserveTemperatureLocateData(long reserveTemperatureLocateData) {
        this.reserveTemperatureLocateData = reserveTemperatureLocateData;
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
