package com.farminserver.db.maternity_pm_sensor;

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
@Table(name = "maternity_pm_sensor")
public class Maternity_PmSensorEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "maternity_room_num")
    private String maternityRoomNum;

    @Column(name = "maternity_pm1_data")
    private double maternityPm1Data;

    @Column(name = "maeternity_pm25_data")
    private double maternityPm25Data;

    @Column(name = "maeternity_pm10_data")
    private double maternityPm10Data;

    @Column(name = "maternity_pm_total_data")
    private double maternityTotalPmData;

    @Column(name = "maternity_pm_input_time")
    private LocalDateTime maternityPmInputTime;

    // Getter and Setter methods

    public String getMaternityRoomNum() {
        return maternityRoomNum;
    }

    public void setMaternityRoomNum(String maternityRoomNum) {
        this.maternityRoomNum = maternityRoomNum;
    }

    public double getMaternityPm1Data() {
        return maternityPm1Data;
    }

    public void setMaternityPm1Data(double maternityPm1Data) {
        this.maternityPm1Data = maternityPm1Data;
    }

    public double getMaternityPm25Data() {
        return maternityPm25Data;
    }

    public void setMaternityPm25Data(double maternityPm25Data) {
        this.maternityPm25Data = maternityPm25Data;
    }

    public double getMaternityPm10Data() {
        return maternityPm10Data;
    }

    public void setMaternityPm10Data(double maternityPm10Data) {
        this.maternityPm10Data = maternityPm10Data;
    }

    public double getMaternityTotalPmData() {
        return maternityTotalPmData;
    }

    public void setMaternityTotalPmData(double maternityTotalPmData) {
        this.maternityTotalPmData = maternityTotalPmData;
    }

    public LocalDateTime getMaternityPmInputTime() {
        return maternityPmInputTime;
    }

    public void setMaternityPmInputTime(LocalDateTime maternityPmInputTime) {
        this.maternityPmInputTime = maternityPmInputTime;
    }
}
