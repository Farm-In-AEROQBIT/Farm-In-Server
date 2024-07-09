package com.farminserver.db.reserve_temperature_sensor;

import com.farminserver.db.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Service;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = false)
@Data
@SuperBuilder
@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reserve_temperature_sensor")

public class Reserve_TemperatureSensorEntity extends BaseEntity {
    @Id
    private String reserveSowsRoomNum;
    private double reserveTemperatureData;
    private LocalDateTime reserveTemperatureInputTime;
    private long reserveTemperatureLocateData;

    public String getReserveSowsRoomNum() {
            return reserveSowsRoomNum;
        }
    public void setReserveSowsRoomNum(String reserveSowsRoomNum) {
        this.reserveSowsRoomNum = reserveSowsRoomNum;
    }


    public double getReserveTemperatureData() {
        return reserveTemperatureData;
    }
    public void setReserveTemperatureData(double reserveTemperatureData) {
        this.reserveTemperatureData = reserveTemperatureData;
    }


    public LocalDateTime getReserveTemperatureInputTime() {
        return reserveTemperatureInputTime;
    }
    public void setReserveTemperatureInputTime(LocalDateTime reserveTemperatureInputTime) {
        this.reserveTemperatureInputTime = reserveTemperatureInputTime;
    }


    public long getReserveTemperatureLocateData() {
        return reserveTemperatureLocateData;
    }
    public void setReserveTemperatureLocateData(long reserveTemperatureLocateData) {
        this.reserveTemperatureLocateData = reserveTemperatureLocateData;
    }



}

