package com.farminserver.db.boars_humidity_sensor;

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
@Table(name = "boars_humidity_sensor")
public class Boars_HumiditySensorEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Boars_Barn_Room_Num;
    private double Boars_Humidity_Data;
    private LocalDateTime Boars_Humidity_Input_Time;

    public String getFarmName() {
        return Boars_Barn_Room_Num;
    }
    public void setFarmName(String Boars_Barn_Room_Num) {
        this.Boars_Barn_Room_Num = Boars_Barn_Room_Num;
    }

    public double getboars_HumidityData() {
        return Boars_Humidity_Data;
    }
    public void setboars_HumidityData(double Boars_Humidity_Data) {
        this.Boars_Humidity_Data = Boars_Humidity_Data;
    }

    public LocalDateTime getboars_Humidity_Input_Time() {
        return Boars_Humidity_Input_Time;
    }
    public void setboars_Humidity_Input_Time(LocalDateTime Boars_Humidity_Input_Time) {
        this.Boars_Humidity_Input_Time = Boars_Humidity_Input_Time;
    }

}
