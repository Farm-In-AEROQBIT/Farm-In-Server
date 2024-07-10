package com.farminserver.db.piglet_pm_sensor;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Service;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = false)
@Data
@SuperBuilder
@Getter
@Setter
@Service
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "piglet_pm_sensor")
public class Piglet_PmSensorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "piglet_pen_room_num")
    private String pigletBarnRoomNum;

    @Column(name = "piglet_pm1_data")
    private double pigletPm1Data;

    @Column(name = "piglet_pm25_data")
    private double pigletPm25Data;

    @Column(name = "piglet_pm10_data")
    private double pigletPm10Data;

    @Column(name = "piglet_pm_total_data")
    private double pigletTotalPmData;

    @Column(name = "piglet_pm_input_time")
    private LocalDateTime pigletPmInputTime;

    // Getter and Setter methods

    public String getPigletBarnRoomNum() {
        return pigletBarnRoomNum;
    }

    public void setPigletBarnRoomNum(String pigletBarnRoomNum) {
        this.pigletBarnRoomNum = pigletBarnRoomNum;
    }

    public double getPigletPm1Data() {
        return pigletPm1Data;
    }

    public void setPigletPm1Data(double pigletPm1Data) {
        this.pigletPm1Data = pigletPm1Data;
    }

    public double getPigletPm25Data() {
        return pigletPm25Data;
    }

    public void setPigletPm25Data(double pigletPm25Data) {
        this.pigletPm25Data = pigletPm25Data;
    }

    public double getPigletPm10Data() {
        return pigletPm10Data;
    }

    public void setPigletPm10Data(double pigletPm10Data) {
        this.pigletPm10Data = pigletPm10Data;
    }

    public double getPigletTotalPmData() {
        return pigletTotalPmData;
    }

    public void setPigletTotalPmData(double pigletTotalPmData) {
        this.pigletTotalPmData = pigletTotalPmData;
    }

    public LocalDateTime getPigletPmInputTime() {
        return pigletPmInputTime;
    }

    public void setPigletPmInputTime(LocalDateTime pigletPmInputTime) {
        this.pigletPmInputTime = pigletPmInputTime;
    }
}
