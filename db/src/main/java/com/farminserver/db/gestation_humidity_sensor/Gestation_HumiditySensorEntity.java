package com.farminserver.db.gestation_humidity_sensor;

import com.farminserver.db.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import jakarta.persistence.*;


@EqualsAndHashCode(callSuper = false)
@Data
@SuperBuilder
@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "gestation_humidity_sensor")

public class Gestation_HumiditySensorEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Gestation_Room_Num;
    private double Gestation_Humidity_Data;
    private LocalDateTime Gestation_Humidity_Input_Time;

    public String getFarmName() {
        return Gestation_Room_Num;
    }

    public void setFarmName(String Gestation_Barn_Room_Num) {
        this.Gestation_Room_Num = Gestation_Barn_Room_Num;
    }


    public double getgestation_HumidityData() {
        return Gestation_Humidity_Data;
    }

    public void setgestation_HumidityData(double Gestation_Humidity_Data) {
        this.Gestation_Humidity_Data = Gestation_Humidity_Data;
    }

    public LocalDateTime getgestation_Humidity_Input_Time() {
        return Gestation_Humidity_Input_Time;
    }

    public void setgestation_Humidity_Input_Time(LocalDateTime Gestation_Humidity_Input_Time) {
        this.Gestation_Humidity_Input_Time = Gestation_Humidity_Input_Time;
    }

}
