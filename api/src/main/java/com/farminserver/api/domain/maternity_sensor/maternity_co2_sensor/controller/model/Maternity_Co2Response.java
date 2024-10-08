package com.farminserver.api.domain.maternity_sensor.maternity_co2_sensor.controller.model;

public class Maternity_Co2Response {
    private String maternityRoomNum;
    private double maternityCo2Data;
    private String unit;
    private long timestamp;

    public Maternity_Co2Response(String maternityRoomNum, double maternityCo2, String unit, long timestamp) {
        this.maternityRoomNum = maternityRoomNum;
        this.maternityCo2Data = maternityCo2;
        this.unit = unit;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public String getMaternityRoomNum() {
        return maternityRoomNum;
    }

    public void setMaternityRoomNum(String maternityRoomNum) {
        this.maternityRoomNum = maternityRoomNum;
    }

    public double getMaternityCo2Data() {
        return maternityCo2Data;
    }

    public void setMaternityCo2(double maternityCo2) {
        this.maternityCo2Data = maternityCo2;
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
