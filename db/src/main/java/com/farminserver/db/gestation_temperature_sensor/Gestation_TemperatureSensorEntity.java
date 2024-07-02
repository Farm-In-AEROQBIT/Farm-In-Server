package com.farminserver.db.gestation_temperature_sensor;

import com.farminserver.db.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Service;
import jakarta.persistence.*;


@EqualsAndHashCode(callSuper = false)
@Data
@SuperBuilder
@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "gestation_temperature_sensor")

public class Gestation_TemperatureSensorEntity extends BaseEntity {

    @Id
    private String Gestation_Room_Num;
    private double Gestation_Temper_Data;
    private String Gestation_Temper_Input_Time;
    private String Gestation_Temper_Locate_Data;

    // Getters and Setters
    public String getGestationRoomNum() {
        return Gestation_Room_Num;
    }

    public void setGestationRoomNum(String Gestation_Room_Num) {
        this.Gestation_Room_Num = Gestation_Room_Num;
    }


    public double getGestationTemperData() {
        return Gestation_Temper_Data;
    }

    public void setGestationTemperData(double Gestation_Temper_Data) {
        this.Gestation_Temper_Data = Gestation_Temper_Data;
    }


    public String getGestationTemperInputTime() {
        return Gestation_Temper_Input_Time;
    }

    public void setGestationTemperInputTime(String Gestation_Temper_Input_Time) {
        this.Gestation_Temper_Input_Time = Gestation_Temper_Input_Time;
    }


    public String getGestationTemperLocateData() {
        return Gestation_Temper_Locate_Data;
    }

    public void setGestationTemperLocateData(String Gestation_Temper_Locate_Data) {
        this.Gestation_Temper_Locate_Data = Gestation_Temper_Locate_Data;
    }

}

