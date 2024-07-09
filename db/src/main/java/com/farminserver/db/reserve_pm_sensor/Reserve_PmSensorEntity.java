package com.farminserver.db.reserve_pm_sensor;

import com.farminserver.db.BaseEntity;
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
@Table(name = "reserve_sows_pm_sensor")

public class Reserve_PmSensorEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)

    //PM1.0 수집 데이터
    public double reserve_Sows_Pm1_Data;

    //PM2.5 수집 데이터
    public double reserve_Pm25_Data;

    //PM10 수집 데이터
    public double reserve_Pm10_Data;

    // 미세먼지 토탈 수집 데이터
    public double reserve_Total_Pm_Data;

    // 미세먼지 데이터 입력 시간
    public long reserve_Pm_Input_Time;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Reserve_Sows_Room_Num;
    private double Reserve_Pm1_Data;
    private double Reserve_Pm25_Data;
    private double Reserve_Pm10_Data;
    private double Reserve_Pm_Total_Data;
    private LocalDateTime Reserve_Sows_Pm_Input_Time;

    public String getFarmName() {
        return Reserve_Sows_Room_Num;
    }
    public void setFarmName(String Reserve_Sows_Room_Num) {
        this.Reserve_Sows_Room_Num = Reserve_Sows_Room_Num;
    }


    public double getreserve_Pm1Data() {
        return Reserve_Pm1_Data;
    }
    public void setreserve_Pm1Data(double Reserve_Pm1_Data) {
        this.Reserve_Pm1_Data = Reserve_Pm1_Data;
    }


    public double getreserve_Pm25Data() {
        return Reserve_Pm25_Data;
    }
    public void setreserve_Pm25Data(double Reserve_Pm25_Data) {
        this.Reserve_Pm25_Data = Reserve_Pm25_Data;
    }


    public double getreserve_Pm10Data() {
        return Reserve_Pm10_Data;
    }
    public void setreserve_Pm10Data(double Reserve_Pm10_Data) {
        this.Reserve_Pm10_Data = Reserve_Pm10_Data;
    }


    public double getreserve_TotalPmData() {
        return Reserve_Pm_Total_Data;
    }
    public void setreserve_TotalPmData(double Reserve_Pm_Total_Data) {
        this.Reserve_Pm_Total_Data = Reserve_Pm_Total_Data;
    }


    public LocalDateTime getreserve_Pm_Input_Time() {
        return Reserve_Sows_Pm_Input_Time;
    }

    public void setreserve_Pm_Input_Time(LocalDateTime Reserve_Pm_Input_Time) {
        this.Reserve_Sows_Pm_Input_Time = Reserve_Pm_Input_Time;
    }




}
