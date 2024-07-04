package com.farminserver.db.boars_temperature_sensor;

import com.farminserver.db.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@EqualsAndHashCode(callSuper = false)
@Data
@SuperBuilder
@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "boars_temperature_sensor")
public class
Boars_TemperatureSeneorEntity extends BaseEntity {
    @Id
    private String BoarsBarnRoomNum;
    private double BoarsTemperData;
    private LocalDateTime BoarsTemperInputTime;
    private long BoarsTemperLocateData;

    // Getters and Setters
    public String getBoarsBarnRoomNum() {
        return BoarsBarnRoomNum;
    }

    public void setBoarsBarnRoomNum(String BoarsBarnRoomNum) {
        this.BoarsBarnRoomNum = BoarsBarnRoomNum;
    }

    public double getBoarsTemperData() {
        return BoarsTemperData;
    }

    public void setBoarsTemperData(double boarsTemperData) {
        this.BoarsTemperData = boarsTemperData;
    }

    public LocalDateTime getBoarsTemperInputTime() {
        return BoarsTemperInputTime;
    }

    public void setBoarsTemperInputTime(LocalDateTime boarsTemperInputTime) {
        this.BoarsTemperInputTime = boarsTemperInputTime;
    }

    public long getBoarsTemperLocateData() {
        return BoarsTemperLocateData;
    }

    public void setBoarsTemperLocateData(long boarsTemperLocateData) {
        this.BoarsTemperLocateData = boarsTemperLocateData;
    }

}
