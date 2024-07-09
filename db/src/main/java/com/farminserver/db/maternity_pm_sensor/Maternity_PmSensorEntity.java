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
@Table(name = "maternity_room_num")


public class Maternity_PmSensorEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)

    //PM1.0 수집 데이터
    public double maternity_Pm1_Data;

    //PM2.5 수집 데이터
    public double maternity_Pm25_Data;

    //PM10 수집 데이터
    public double maternity_Pm10_Data;

    // 미세먼지 토탈 수집 데이터
    public double maternity_Total_Pm_Data;

    // 미세먼지 데이터 입력 시간
    public long maternity_Pm_Input_Time;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Maternity_Room_Num;
    private double Maternity_Pm1_Data;
    private double Maternity_Pm25_Data;
    private double Maternity_Pm10_Data;
    private double Maternity_Total_Pm_Data;
    private LocalDateTime Maternity_Pm_Input_Time;

    public String getFarmName() {
        return Maternity_Room_Num;
    }

    public void setFarmName(String Maternity_Room_Num) {
        this.Maternity_Room_Num = Maternity_Room_Num;
    }


    public double getmaternity_Pm1Data() {
        return Maternity_Pm1_Data;
    }

    public void setmaternity_Pm1Data(double Maternity_Pm1_Data) {
        this.Maternity_Pm1_Data = Maternity_Pm1_Data;
    }


    public double getmaternity_Pm25Data() {
        return Maternity_Pm25_Data;
    }

    public void setmaternity_Pm25Data(double Maternity_Pm25_Data) {
        this.Maternity_Pm25_Data = Maternity_Pm25_Data;
    }


    public double getmaternity_Pm10Data() {
        return Maternity_Pm10_Data;
    }

    public void setmaternity_Pm10Data(double Maternity_Pm10_Data) {
        this.Maternity_Pm10_Data = Maternity_Pm10_Data;
    }


    public double getmaternity_TotalPmData() {
        return Maternity_Total_Pm_Data;
    }

    public void setmaternity_TotalPmData(double Maternity_Total_Pm_Data) {
        this.Maternity_Total_Pm_Data = Maternity_Total_Pm_Data;
    }


    public LocalDateTime getmaternity_Pm_Input_Time() {
        return Maternity_Pm_Input_Time;
    }

    public void setmaternity_Pm_Input_Time(LocalDateTime Maternity_Pm_Input_Time) {
        this.Maternity_Pm_Input_Time = Maternity_Pm_Input_Time;
    }




}
