package com.farminserver.db.pm_sensor;

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
@Table(name = "Pm_Sensor")
public class PmSensorEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    // 미세먼지 데이터 입력 시간
    public long pm_input_time;

    // 미세먼지 토탈 수집 데이터
    public double total_pm_data;

    //PM1.0 수집 데이터
    public double PM1_data;

    //PM2.5 수집 데이터
    public double PM25_data;

    //PM10 수집 데이터
    public double PM10_data;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String farmName;
    private double pm1Data;
    private double pm25Data;
    private double pm10Data;
    private double totalpmData;
    private LocalDateTime pmInputTime;

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public double getPm1Data() {
        return pm1Data;
    }

    public void setPm1Data(double pm1Data) {
        this.pm1Data = pm1Data;
    }

    public double getPm25Data() {
        return pm25Data;
    }

    public void setPm25Data(double pm25Data) {
        this.pm25Data = pm25Data;
    }

    public LocalDateTime getPmInputTime() {
        return pmInputTime;
    }

    public void setPmInputTime(LocalDateTime pmInputTime) {
        this.pmInputTime = pmInputTime;
    }


}
