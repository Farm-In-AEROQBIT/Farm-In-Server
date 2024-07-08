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
    @Id
    @GeneratedValue(strategy = IDENTITY)
    //PM1.0 수집 데이터
    public double finishing_Pm1_Data;

    //PM2.5 수집 데이터
    public double finishing_Pm25_Data;

    //PM10 수집 데이터
    public double finishing_Pm10_Data;

    // 미세먼지 토탈 수집 데이터
    public double finishing_Total_Pm_Data;

    // 미세먼지 데이터 입력 시간
    public long finishing_Pm_Input_Time;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Finishing_Barn_Room_Num;
    private double Finishing_Pm1_Data;
    private double Finishing_Pm25_Data;
    private double Finishing_Pm10_Data;
    private double Finishing_Total_Pm_Data;
    private LocalDateTime Finishing_Pm_Input_Time;


    public String getFarmName() {
        return Finishing_Barn_Room_Num;
    }

    public void setFarmName(String Finishing_Barn_Room_Num) {
        this.Finishing_Barn_Room_Num = Finishing_Barn_Room_Num;
    }

    public double getfinishing_Pm1Data() {
        return Finishing_Pm1_Data;
    }

    public void setfinishing_Pm1Data(double Finishing_Pm1_Data) {
        this.Finishing_Pm1_Data = Finishing_Pm1_Data;
    }


    public double getfinishing_Pm25Data() {
        return Finishing_Pm25_Data;
    }

    public void setfinishing_Pm25Data(double Finishing_Pm25_Data) {
        this.Finishing_Pm25_Data = Finishing_Pm25_Data;
    }


    public double getfinishing_Pm10Data() {
        return Finishing_Pm10_Data;
    }

    public void setfinishing_Pm10Data(double Finishing_Pm10_Data) {
        this.Finishing_Pm10_Data = Finishing_Pm10_Data;
    }


    public double getfinishing_TotalPmData() {
        return Finishing_Total_Pm_Data;
    }

    public void setfinishing_TotalPmData(double Finishing_Total_Pm_Data) {
        this.Finishing_Total_Pm_Data = Finishing_Total_Pm_Data;
    }


    public LocalDateTime getfinishing_Pm_Input_Time() {
        return Finishing_Pm_Input_Time;
    }

    public void setfinishing_Pm_Input_Time(LocalDateTime Finishing_Pm_Input_Time) {
        this.Finishing_Pm_Input_Time = Finishing_Pm_Input_Time;
    }


}
