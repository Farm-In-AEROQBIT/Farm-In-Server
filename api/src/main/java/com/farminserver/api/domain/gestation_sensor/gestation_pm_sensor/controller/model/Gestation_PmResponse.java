package com.farminserver.api.domain.gestation_sensor.gestation_pm_sensor.controller.model;

public class Gestation_PmResponse {
    private String gestationRoomNum;
    private double pm1_0;
    private double pm2_5;
    private double pm10;
    private double totalPm;
    private String unit;
    private long timestamp;

    public Gestation_PmResponse(String gestationRoomNum,double pm1_0, double pm2_5, double pm10, double totalPm, String unit, long timestamp) {
        this.gestationRoomNum = gestationRoomNum;
        this.pm1_0 = pm1_0;
        this.pm2_5 = pm2_5;
        this.pm10 = pm10;
        this.totalPm = totalPm;
        this.unit = unit;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public String getGestationRoomNum() {
        return gestationRoomNum;
    }
    public void setGestationRoomNum(String gestationRoomNum) {
        this.gestationRoomNum = gestationRoomNum;
    }

    public double getPm1_0() {
        return pm1_0;
    }

    public void setPm1_0(double pm1_0) {
        this.pm1_0 = pm1_0;
    }

    public double getPm2_5() {
        return pm2_5;
    }

    public void setPm2_5(double pm2_5) {
        this.pm2_5 = pm2_5;
    }

    public double getPm10() {
        return pm10;
    }

    public void setPm10(double pm10) {
        this.pm10 = pm10;
    }

    public double getTotalPm() {
        return totalPm;
    }

    public void setTotalPm(double totalPm) {
        this.totalPm = totalPm;
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
