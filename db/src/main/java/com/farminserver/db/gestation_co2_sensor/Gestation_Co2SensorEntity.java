package com.farminserver.db.gestation_co2_sensor;

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
@Table(name = "gestation_co2_sensor")

public class Gestation_Co2SensorEntity extends BaseEntity {

    private String Gestation_Room_Num;
    private double Gestation_Co2_Data;
    private LocalDateTime Gestation_Co2_Input_Time;

    public String getFarmName() {
        return Gestation_Room_Num;
    }

    public void setFarmName(String Gestation_Barn_Room_Num) {
        this.Gestation_Room_Num = Gestation_Barn_Room_Num;
    }


    public double getgestationCo2Data() {
        return Gestation_Co2_Data;
    }

    public void setgestation_Co2Data(double Gestation_Co2_Data) {
        this.Gestation_Co2_Data = Gestation_Co2_Data;
    }


    public LocalDateTime getCo2InputTime() {
        return Gestation_Co2_Input_Time;
    }

    public void setCo2InputTime(LocalDateTime Gestation_Co2_Input_Time) {
        this.Gestation_Co2_Input_Time = Gestation_Co2_Input_Time;
    }

}
