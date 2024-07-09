package com.farminserver.db.piglet_pm_sensor;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import static jakarta.persistence.GenerationType.IDENTITY;


@EqualsAndHashCode(callSuper = false)
@Data
@SuperBuilder
@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "piglet_pm_sensor")

public class Piglet_PmSensorEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)

    //PM1.0 수집 데이터
    public double piglet_Pm1_Data;

    //PM2.5 수집 데이터
    public double piglet_Pm25_Data;

    //PM10 수집 데이터
    public double piglet_Pm10_Data;

    // 미세먼지 토탈 수집 데이터
    public double piglet_Total_Pm_Data;

    // 미세먼지 데이터 입력 시간
    public long piglet_Pm_Input_Time;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Piglet_Barn_Room_Num;
    private double Piglet_Pm1_Data;
    private double Piglet_Pm25_Data;
    private double Piglet_Pm10_Data;
    private double Piglet_Total_Pm_Data;
    private LocalDateTime Piglet_Pm_Input_Time;

    public String getFarmName() {
        return Piglet_Barn_Room_Num;
    }

    public void setFarmName(String Piglet_Barn_Room_Num) {
        this.Piglet_Barn_Room_Num = Piglet_Barn_Room_Num;
    }


    public double getpiglet_Pm1Data() {
        return Piglet_Pm1_Data;
    }

    public void setpiglet_Pm1Data(double Piglet_Pm1_Data) {
        this.Piglet_Pm1_Data = Piglet_Pm1_Data;
    }


    public double getpiglet_Pm25Data() {
        return Piglet_Pm25_Data;
    }

    public void setpiglet_Pm25Data(double Piglet_Pm25_Data) {
        this.Piglet_Pm25_Data = Piglet_Pm25_Data;
    }


    public double getpiglet_Pm10Data() {
        return Piglet_Pm10_Data;
    }

    public void setpiglets_Pm10Data(double Piglet_Pm10_Data) {
        this.Piglet_Pm10_Data = Piglet_Pm10_Data;
    }


    public double getpiglet_TotalPmData() {
        return Piglet_Total_Pm_Data;
    }

    public void setpiglet_TotalPmData(double Piglet_Total_Pm_Data) {
        this.Piglet_Total_Pm_Data = Piglet_Total_Pm_Data;
    }


    public LocalDateTime getpiglet_Pm_Input_Time() {
        return Piglet_Pm_Input_Time;
    }

    public void setpiglet_Pm_Input_Time(LocalDateTime Piglet_Pm_Input_Time) {
        this.Piglet_Pm_Input_Time = Piglet_Pm_Input_Time;
    }




}
