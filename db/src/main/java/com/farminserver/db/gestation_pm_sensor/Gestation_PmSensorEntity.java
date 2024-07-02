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
    @Id
    @GeneratedValue(strategy = IDENTITY)

    //PM1.0 수집 데이터
    public double gestation_Pm1_Data;

    //PM2.5 수집 데이터
    public double gestation_Pm25_Data;

    //PM10 수집 데이터
    public double gestation_Pm10_Data;

    // 미세먼지 토탈 수집 데이터
    public double gestation_Total_Pm_Data;

    // 미세먼지 데이터 입력 시간
    public long gestation_Pm_Input_Time;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Gestation_Room_Num;
    private double Gestation_Pm1_Data;
    private double Gestation_Pm25_Data;
    private double Gestation_Pm10_Data;
    private double Gestation_Total_Pm_Data;
    private LocalDateTime Gestation_Pm_Input_Time;

    public String getFarmName() {
        return Gestation_Room_Num;
    }

    public void setFarmName(String Gestation_Room_Num) {
        this.Gestation_Room_Num = Gestation_Room_Num;
    }


    public double getgestation_Pm1Data() {
        return Gestation_Pm1_Data;
    }

    public void setgestation_Pm1Data(double Boars_Pm1_Data) {
        this.Gestation_Pm1_Data = Boars_Pm1_Data;
    }


    public double getgestation_Pm25Data() {
        return Gestation_Pm25_Data;
    }

    public void setgestation_Pm25Data(double Gestation_Pm25_Data) {
        this.Gestation_Pm25_Data = Gestation_Pm25_Data;
    }


    public double getgestation_Pm10Data() {
        return Gestation_Pm10_Data;
    }

    public void setgestation_Pm10Data(double Gestation_Pm10_Data) {
        this.Gestation_Pm10_Data = Gestation_Pm10_Data;
    }


    public double getgestation_TotalPmData() {
        return Gestation_Total_Pm_Data;
    }

    public void setgestation_TotalPmData(double Gestation_Total_Pm_Data) {
        this.Gestation_Total_Pm_Data = Gestation_Total_Pm_Data;
    }


    public LocalDateTime getgestation_Pm_Input_Time() {
        return Gestation_Pm_Input_Time;
    }

    public void setgestation_Pm_Input_Time(LocalDateTime Gestation_Pm_Input_Time) {
        this.Gestation_Pm_Input_Time = Gestation_Pm_Input_Time;
    }




}