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

    //PM1.0 수집 데이터
    public double boars_Pm1_Data;

    //PM2.5 수집 데이터
    public double boars_Pm25_Data;

    //PM10 수집 데이터
    public double boars_Pm10_Data;

    // 미세먼지 토탈 수집 데이터
    public double boars_Total_Pm_Data;

    // 미세먼지 데이터 입력 시간
    public long boars_Pm_Input_Time;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Boars_Barn_Room_Num;
    private double Boars_Pm1_Data;
    private double Boars_Pm25_Data;
    private double Boars_Pm10_Data;
    private double Boars_Total_Pm_Data;
    private LocalDateTime Boars_Pm_Input_Time;

    public String getFarmName() {
        return Boars_Barn_Room_Num;
    }

    public void setFarmName(String Boars_Barn_Room_Num) {
        this.Boars_Barn_Room_Num = Boars_Barn_Room_Num;
    }


    public double getboars_Pm1Data() {
        return Boars_Pm1_Data;
    }

    public void setboars_Pm1Data(double Boars_Pm1_Data) {
        this.Boars_Pm1_Data = Boars_Pm1_Data;
    }


    public double getboars_Pm25Data() {
        return Boars_Pm25_Data;
    }

    public void setboars_Pm25Data(double Boars_Pm25_Data) {
        this.Boars_Pm25_Data = Boars_Pm25_Data;
    }


    public double getboars_Pm10Data() {
        return Boars_Pm10_Data;
    }

    public void setboars_Pm10Data(double Boars_Pm10_Data) {
        this.Boars_Pm10_Data = Boars_Pm10_Data;
    }


    public double getboars_TotalPmData() {
        return Boars_Total_Pm_Data;
    }

    public void setboars_TotalPmData(double Boars_Total_Pm_Data) {
        this.Boars_Total_Pm_Data = Boars_Total_Pm_Data;
    }


    public LocalDateTime getboars_Pm_Input_Time() {
        return Boars_Pm_Input_Time;
    }

    public void setboars_Pm_Input_Time(LocalDateTime Boars_Pm_Input_Time) {
        this.Boars_Pm_Input_Time = Boars_Pm_Input_Time;
    }




}
