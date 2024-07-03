package com.farminserver.db.boars_temperature_sensor;

import com.farminserver.db.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Service;


@EqualsAndHashCode(callSuper = false)
@Data
@SuperBuilder
@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "boars_temperature_sensor")
public class Boars_TemperatureSensorEntity extends BaseEntity {
    @Id
    private String Boars_Barn_Room_Num;
    private double Boars_Temper_Data;
    private String Boars_Temper_Input_Time;
    private String Boars_Temper_Locate_Data;

    // Getters and Setters
    public String getBoarsBarnRoomNum() {
        return Boars_Barn_Room_Num;
    }

    public void setBoarsBarnRoomNum(String Boars_Barn_Room_Num) {
        this.Boars_Barn_Room_Num = Boars_Barn_Room_Num;
    }


    public double getBoarsTemperData() {
        return Boars_Temper_Data;
    }

    public void setBoarsTemperData(double Boars_Temper_Data) {
        this.Boars_Temper_Data = Boars_Temper_Data;
    }


    public String getBoarsTemperInputTime() {
        return Boars_Temper_Input_Time;
    }

    public void setBoarsTemperInputTime(String Boars_Temper_Input_Time) {
        this.Boars_Temper_Input_Time = Boars_Temper_Input_Time;
    }


    public String getBoarsTemperLocateData() {
        return Boars_Temper_Locate_Data;
    }

    public void setBoarsTemperLocateData(String Boars_Temper_Locate_Data) {
        this.Boars_Temper_Locate_Data = Boars_Temper_Locate_Data;
    }

}
