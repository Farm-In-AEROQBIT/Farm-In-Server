package com.farminserver.db.piglet_temperature_sensor;

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
@Table(name = "piglet_temperature_sensor")

public class Piglet_TemperatureSensorEntity extends BaseEntity {
    @Id
    private String Piglet_Room_Num;
    private double Piglet_Temper_Data;
    private LocalDateTime Piglet_Temper_Input_Time;
    private long Piglet_Temper_Locate_Data;

    // Getters and Setters
    public String getPigletRoomNum() {
        return Piglet_Room_Num;
    }

    public void setPigletBarnRoomNum(String Piglet_Room_Num) {
        this.Piglet_Room_Num = Piglet_Room_Num;
    }


    public double getPigletTemperData() {
        return Piglet_Temper_Data;
    }

    public void setPigletTemperData(double Piglet_Temper_Data) {
        this.Piglet_Temper_Data = Piglet_Temper_Data;
    }


    public LocalDateTime getPigletTemperInputTime() {
        return Piglet_Temper_Input_Time;
    }

    public void setPigletTemperInputTime(LocalDateTime Piglet_Temper_Input_Time) {
        this.Piglet_Temper_Input_Time = Piglet_Temper_Input_Time;
    }

    public long getPigletTemperLocateData() {
        return Piglet_Temper_Locate_Data;
    }

    public void setPigletTemperLocateData(long Piglet_Temper_Locate_Data) {
        this.Piglet_Temper_Locate_Data = Piglet_Temper_Locate_Data;
    }

}