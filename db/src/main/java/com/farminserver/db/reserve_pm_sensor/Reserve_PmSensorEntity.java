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
import jakarta.persistence.Column;

import static jakarta.persistence.GenerationType.IDENTITY;

@EqualsAndHashCode(callSuper = false)
@Data
@SuperBuilder
@Getter
@Setter
@Service
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reserve_sows_pm_sensor")
public class Reserve_PmSensorEntity extends BaseEntity {

    @Column(name = "reserve_sows_room_num")
    private String reserveSowsRoomNum;

    @Column(name = "reserve_sows_pm1_data")
    private double reservePm1Data;

    @Column(name = "reserve_sows_pm25_data")
    private double reservePm25Data;

    @Column(name = "reserve_sows_pm10_data")
    private double reservePm10Data;

    @Column(name = "reserve_sows_pm_total_data")
    private double reserveTotalPmData;

    @Column(name = "reserve_sows_pm_input_time")
    private LocalDateTime reservePmInputTime;

    // Getter and Setter methods

    public String getReserveSowsRoomNum() {
        return reserveSowsRoomNum;
    }

    public void setReserveSowsRoomNum(String reserveSowsRoomNum) {
        this.reserveSowsRoomNum = reserveSowsRoomNum;
    }

    public double getReservePm1Data() {
        return reservePm1Data;
    }

    public void setReservePm1Data(double reservePm1Data) {
        this.reservePm1Data = reservePm1Data;
    }

    public double getReservePm25Data() {
        return reservePm25Data;
    }

    public void setReservePm25Data(double reservePm25Data) {
        this.reservePm25Data = reservePm25Data;
    }

    public double getReservePm10Data() {
        return reservePm10Data;
    }

    public void setReservePm10Data(double reservePm10Data) {
        this.reservePm10Data = reservePm10Data;
    }

    public double getReserveTotalPmData() {
        return reserveTotalPmData;
    }

    public void setReserveTotalPmData(double reserveTotalPmData) {
        this.reserveTotalPmData = reserveTotalPmData;
    }

    public LocalDateTime getReservePmInputTime() {
        return reservePmInputTime;
    }

    public void setReservePmInputTime(LocalDateTime reservePmInputTime) {
        this.reservePmInputTime = reservePmInputTime;
    }
}
