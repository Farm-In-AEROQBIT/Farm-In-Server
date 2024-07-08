package com.farminserver.db.growing_temperature_sensor;

import com.farminserver.db.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Service;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = false)
@Data
@SuperBuilder
@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "growing_temperature_sensor")

public class Growing_TemperatureSensorEntity extends BaseEntity {
    @Id
    private String Growing_Room_Num;
    private double Growing_Temper_Data;
    private LocalDateTime Growing_Temper_Input_Time;
    private long Growing_Temper_Locate_Data;

    // Getters and Setters
    public String getGrowingRoomNum() {
        return Growing_Room_Num;
    }

    public void setGrowingRoomNum(String Growing_Barn_Room_Num) {
        this.Growing_Room_Num = Growing_Barn_Room_Num;
    }


    public double getGrowingTemperData() {
        return Growing_Temper_Data;
    }

    public void setGrowingTemperData(double Growing_Temper_Data) {
        this.Growing_Temper_Data = Growing_Temper_Data;
    }


    public LocalDateTime getGrowingTemperInputTime() {
        return Growing_Temper_Input_Time;
    }

    public void setGrowingTemperInputTime(LocalDateTime Growing_Temper_Input_Time) {
        this.Growing_Temper_Input_Time = Growing_Temper_Input_Time;
    }


    public long getGrowingTemperLocateData() {
        return Growing_Temper_Locate_Data;
    }

    public void setGrowingTemperLocateData(long Growing_Temper_Locate_Data) {
        this.Growing_Temper_Locate_Data = Growing_Temper_Locate_Data;
    }

}

