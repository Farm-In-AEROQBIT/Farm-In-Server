package com.farminserver.db.reserve_temperature_sensor;

import com.farminserver.db.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;


@EqualsAndHashCode(callSuper = false)
@Data
@SuperBuilder
@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reserve_temperature_sensor")

public class Reserve_TemperatureSensorEntitiy extends BaseEntity {
    @Id
    private String reserveSowsRoomNum;
    private String reserveTemperatureData;
    private String reserveTemperatureInputTime;
    private String reserveTemperatureLocate;

    public String getReserveSowsRoomNum() {
            return reserveSowsRoomNum;
        }

    public void setReserveSowsRoomNum(String reserveSowsRoomNum) {
        this.reserveSowsRoomNum = reserveSowsRoomNum;
    }


    public String getReserveTemperatureData() {
        return reserveTemperatureData;
    }

    public void setReserveTemperatureData(String reserveTemperatureData) {
        this.reserveTemperatureData = reserveTemperatureData;
    }


    public String getReserveTemperatureInputTime() {
        return reserveTemperatureInputTime;
    }

    public void setReserveTemperatureInputTime(String reserveTemperatureInputTime) {
        this.reserveTemperatureInputTime = reserveTemperatureInputTime;
    }


    public String getReserveTemperatureLocate() {
        return reserveTemperatureLocate;
    }

    public void setReserveTemperatureLocate(String reserveTemperatureLocate) {
        this.reserveTemperatureLocate = reserveTemperatureLocate;
    }



}

