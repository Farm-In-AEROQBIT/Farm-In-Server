package com.farminserver.db.gestation_pm_sensor;

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
@Table(name = "gestation_pm_sensor")
public class Gestation_PmSensorEntity extends BaseEntity {

    @Column(name = "gestation_room_num")
    private String gestationRoomNum;

    @Column(name = "gestation_pm1_data")
    private double gestationPm1Data;

    @Column(name = "gestation_pm25_data")
    private double gestationPm25Data;

    @Column(name = "gestation_pm10_data")
    private double gestationPm10Data;

    @Column(name = "gestation_pm_total")
    private double gestationTotalPmData;

    @Column(name = "gestation_pm_input_time")
    private LocalDateTime gestationPmInputTime;

    // Getter and Setter methods

    public String getGestationRoomNum() {
        return gestationRoomNum;
    }

    public void setGestationRoomNum(String gestationRoomNum) {
        this.gestationRoomNum = gestationRoomNum;
    }

    public double getGestationPm1Data() {
        return gestationPm1Data;
    }

    public void setGestationPm1Data(double gestationPm1Data) {
        this.gestationPm1Data = gestationPm1Data;
    }

    public double getGestationPm25Data() {
        return gestationPm25Data;
    }

    public void setGestationPm25Data(double gestationPm25Data) {
        this.gestationPm25Data = gestationPm25Data;
    }

    public double getGestationPm10Data() {
        return gestationPm10Data;
    }

    public void setGestationPm10Data(double gestationPm10Data) {
        this.gestationPm10Data = gestationPm10Data;
    }

    public double getGestationTotalPmData() {
        return gestationTotalPmData;
    }

    public void setGestationTotalPmData(double gestationTotalPmData) {
        this.gestationTotalPmData = gestationTotalPmData;
    }

    public LocalDateTime getGestationPmInputTime() {
        return gestationPmInputTime;
    }

    public void setGestationPmInputTime(LocalDateTime gestationPmInputTime) {
        this.gestationPmInputTime = gestationPmInputTime;
    }
}
