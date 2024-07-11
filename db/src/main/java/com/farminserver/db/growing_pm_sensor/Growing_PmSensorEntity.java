package com.farminserver.db.growing_pm_sensor;

import com.farminserver.db.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@EqualsAndHashCode(callSuper = false)
@Data
@SuperBuilder
@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "growing_pm_sensor")
public class Growing_PmSensorEntity extends BaseEntity {

    @Column(name = "growing_room_num")
    private String growingRoomNum;

    @Column(name = "growing_pm1_data")
    private double growingPm1Data;

    @Column(name = "growing_pm25_data")
    private double growingPm25Data;

    @Column(name = "growing_pm10_data")
    private double growingPm10Data;

    @Column(name = "growing_pm_total")
    private double growingTotalPmData;

    @Column(name = "growing_pm_input_time")
    private LocalDateTime growingPmInputTime;

    // Getter and Setter methods

    public String getGrowingRoomNum() {
        return growingRoomNum;
    }

    public void setGrowingRoomNum(String growingRoomNum) {
        this.growingRoomNum = growingRoomNum;
    }

    public double getGrowingPm1Data() {
        return growingPm1Data;
    }

    public void setGrowingPm1Data(double growingPm1Data) {
        this.growingPm1Data = growingPm1Data;
    }

    public double getGrowingPm25Data() {
        return growingPm25Data;
    }

    public void setGrowingPm25Data(double growingPm25Data) {
        this.growingPm25Data = growingPm25Data;
    }

    public double getGrowingPm10Data() {
        return growingPm10Data;
    }

    public void setGrowingPm10Data(double growingPm10Data) {
        this.growingPm10Data = growingPm10Data;
    }

    public double getGrowingTotalPmData() {
        return growingTotalPmData;
    }

    public void setGrowingTotalPmData(double growingTotalPmData) {
        this.growingTotalPmData = growingTotalPmData;
    }

    public LocalDateTime getGrowingPmInputTime() {
        return growingPmInputTime;
    }

    public void setGrowingPmInputTime(LocalDateTime growingPmInputTime) {
        this.growingPmInputTime = growingPmInputTime;
    }
}
