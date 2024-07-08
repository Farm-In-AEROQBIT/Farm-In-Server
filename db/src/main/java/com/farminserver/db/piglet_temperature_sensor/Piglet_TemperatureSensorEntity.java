package com.farminserver.db.piglet_temperature_sensor;

import com.farminserver.db.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Service;
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
@Table(name = "piglet_temperature_sensor")

public class Piglet_TemperatureSensorEntity extends BaseEntity {
    @Id
    private String Piglet_Room_Num;
    private double Piglet_Temper_Data;
    private String Piglet_Temper_Input_Time;
    private String Piglet_Temper_Locate_Data;

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


    public String getPigletTemperInputTime() {
        return Piglet_Temper_Input_Time;
    }

    public void setPigletTemperInputTime(String Piglet_Temper_Input_Time) {
        this.Piglet_Temper_Input_Time = Piglet_Temper_Input_Time;
    }

    public String getPigletTemperLocateData() {
        return Piglet_Temper_Locate_Data;
    }

    public void setPigletTemperLocateData(String Piglet_Temper_Locate_Data) {
        this.Piglet_Temper_Locate_Data = Piglet_Temper_Locate_Data;
    }

}