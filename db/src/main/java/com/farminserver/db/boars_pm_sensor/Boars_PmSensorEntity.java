package com.farminserver.db.boars_pm_sensor;

import com.farminserver.db.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@EqualsAndHashCode(callSuper = false)
@Data
@SuperBuilder
@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "boars_pm_sensor")
public class Boars_PmSensorEntity extends BaseEntity {

    @Column(name = "boars_barn_room_num")
    private String boarsBarnRoomNum;

    @Column(name = "boars_pm1_data")
    private double boarsPm1Data;

    @Column(name = "boars_pm25_data")
    private double boarsPm25Data;

    @Column(name = "boars_pm10")
    private double boarsPm10Data;

    @Column(name = "boars_totalpm_data")
    private double boarsTotalPmData;

    @Column(name = "boars_pm_input_time")
    private LocalDateTime boarsPmInputTime;

    // Getter and Setter methods

    public String getBoarsBarnRoomNum() {
        return boarsBarnRoomNum;
    }

    public void setBoarsBarnRoomNum(String boarsBarnRoomNum) {
        this.boarsBarnRoomNum = boarsBarnRoomNum;
    }

    public double getBoarsPm1Data() {
        return boarsPm1Data;
    }

    public void setBoarsPm1Data(double boarsPm1Data) {
        this.boarsPm1Data = boarsPm1Data;
    }

    public double getBoarsPm25Data() {
        return boarsPm25Data;
    }

    public void setBoarsPm25Data(double boarsPm25Data) {
        this.boarsPm25Data = boarsPm25Data;
    }

    public double getBoarsPm10Data() {
        return boarsPm10Data;
    }

    public void setBoarsPm10Data(double boarsPm10Data) {
        this.boarsPm10Data = boarsPm10Data;
    }

    public double getBoarsTotalPmData() {
        return boarsTotalPmData;
    }

    public void setBoarsTotalPmData(double boarsTotalPmData) {
        this.boarsTotalPmData = boarsTotalPmData;
    }

    public LocalDateTime getBoarsPmInputTime() {
        return boarsPmInputTime;
    }

    public void setBoarsPmInputTime(LocalDateTime boarsPmInputTime) {
        this.boarsPmInputTime = boarsPmInputTime;
    }
}
