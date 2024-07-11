package com.farminserver.db.finishing_pm_sensor;

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
@Table(name = "finishing_pm_sensor")
public class Finishing_PmSensorEntity extends BaseEntity {

    @Column(name = "finishing_room_num")
    private String finishingBarnRoomNum;

    @Column(name = "finishing_pm1_data")
    private double finishingPm1Data;

    @Column(name = "finishing_pm25_data")
    private double finishingPm25Data;

    @Column(name = "finishing_pm10_data")
    private double finishingPm10Data;

    @Column(name = "finishing_pm_total_data")
    private double finishingTotalPmData;

    @Column(name = "finishing_pm_input_time")
    private LocalDateTime finishingPmInputTime;

    // Getter and Setter methods

    public String getFinishingBarnRoomNum() {
        return finishingBarnRoomNum;
    }

    public void setFinishingBarnRoomNum(String finishingBarnRoomNum) {
        this.finishingBarnRoomNum = finishingBarnRoomNum;
    }

    public double getFinishingPm1Data() {
        return finishingPm1Data;
    }

    public void setFinishingPm1Data(double finishingPm1Data) {
        this.finishingPm1Data = finishingPm1Data;
    }

    public double getFinishingPm25Data() {
        return finishingPm25Data;
    }

    public void setFinishingPm25Data(double finishingPm25Data) {
        this.finishingPm25Data = finishingPm25Data;
    }

    public double getFinishingPm10Data() {
        return finishingPm10Data;
    }

    public void setFinishingPm10Data(double finishingPm10Data) {
        this.finishingPm10Data = finishingPm10Data;
    }

    public double getFinishingTotalPmData() {
        return finishingTotalPmData;
    }

    public void setFinishingTotalPmData(double finishingTotalPmData) {
        this.finishingTotalPmData = finishingTotalPmData;
    }

    public LocalDateTime getFinishingPmInputTime() {
        return finishingPmInputTime;
    }

    public void setFinishingPmInputTime(LocalDateTime finishingPmInputTime) {
        this.finishingPmInputTime = finishingPmInputTime;
    }
}
