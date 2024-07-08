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
    @Id
    @GeneratedValue(strategy = IDENTITY)

    //PM1.0 수집 데이터
    public double growing_Pm1_Data;

    //PM2.5 수집 데이터
    public double growing_Pm25_Data;

    //PM10 수집 데이터
    public double growing_Pm10_Data;

    // 미세먼지 토탈 수집 데이터
    public double growing_Total_Pm_Data;

    // 미세먼지 데이터 입력 시간
    public LocalDateTime growing_Pm_Input_Time;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Growing_Room_Num;
    private double Growing_Pm1_Data;
    private double Growing_Pm25_Data;
    private double Growing_Pm10_Data;
    private double Growing_Total_Pm_Data;
    private LocalDateTime Growing_Pm_Input_Time;

    public String getFarmName() {
        return Growing_Room_Num;
    }

    public void setFarmName(String Growing_Room_Num) {
        this.Growing_Room_Num = Growing_Room_Num;
    }


    public double getgrowing_Pm1Data() {
        return Growing_Pm1_Data;
    }

    public void setgrowing_Pm1Data(double Growing_Pm1_Data) {
        this.Growing_Pm1_Data = Growing_Pm1_Data;
    }


    public double getgrowing_Pm25Data() {
        return Growing_Pm25_Data;
    }

    public void setgrowing_Pm25Data(double Growing_Pm25_Data) {
        this.Growing_Pm25_Data =Growing_Pm25_Data;
    }


    public double getgrowing_Pm10Data() {
        return Growing_Pm10_Data;
    }

    public void setgrowing_Pm10Data(double Growing_Pm10_Data) {
        this.Growing_Pm10_Data = Growing_Pm10_Data;
    }


    public double getgrowing_TotalPmData() {
        return Growing_Total_Pm_Data;
    }

    public void setgrowing_TotalPmData(double Growing_Total_Pm_Data) {
        this.Growing_Total_Pm_Data = Growing_Total_Pm_Data;
    }


    public LocalDateTime getgrowing_Pm_Input_Time() {
        return Growing_Pm_Input_Time;
    }

    public void setgrowing_Pm_Input_Time(LocalDateTime Growing_Pm_Input_Time) {
        this.Growing_Pm_Input_Time = Growing_Pm_Input_Time;
    }




}
