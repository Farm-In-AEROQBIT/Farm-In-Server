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
    @Id
    @GeneratedValue(strategy = IDENTITY)
    // 미세먼지 데이터 입력 시간
    public long boars_pm_input_time;

    // 미세먼지 토탈 수집 데이터
    public double boars_total_pm_data;

    //PM1.0 수집 데이터
    public double boars_PM1_data;

    //PM2.5 수집 데이터
    public double boars_PM25_data;

    //PM10 수집 데이터
    public double boars_PM10_data;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String farmName;
    private double boars_pm1Data;
    private double boars_pm25Data;
    private double boars_pm10Data;
    private double boars_totalpmData;
    private LocalDateTime boars_pmInputTime;

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public double getboars_Pm1Data() {
        return boars_pm1Data;
    }

    public void setboars_Pm1Data(double Boars_Pm1Data) {
        this.boars_pm1Data = Boars_Pm1Data;
    }

    public double getboars_Pm25Data() {
        return boars_pm25Data;
    }

    public void setboars_Pm25Data(double pm25Data) {
        this.boars_pm25Data = pm25Data;
    }

    public LocalDateTime getboars_PmInputTime() {
        return boars_pmInputTime;
    }

    public void setboars_PmInputTime(LocalDateTime Boars_PmInputTime) {
        this.boars_pmInputTime = Boars_PmInputTime;
    }


}
