package com.farminserver.db.piglet_co2_sensor;

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
@Table(name = "piglet_co2_sensor")

public class Piglet_Co2SensorEntity extends BaseEntity {

    private String Piglet_Room_Num;
    private double Piglet_Co2_Data;
    private LocalDateTime Piglet_Co2_Input_Time;


    public String getFarmName() {
        return Piglet_Room_Num;
    }

    public void setFarmName(String Piglet_Barn_Room_Num) {
        this.Piglet_Room_Num = Piglet_Barn_Room_Num;
    }


    public double getpiglet_Co2Data() {
        return Piglet_Co2_Data;
    }

    public void setpiglet_Co2Data(double Piglet_Co2_Data) {
        this.Piglet_Co2_Data = Piglet_Co2_Data;
    }


    public LocalDateTime getCo2InputTime() {
        return Piglet_Co2_Input_Time;
    }

    public void setCo2InputTime(LocalDateTime Piglet_Co2_Input_Time) {
        this.Piglet_Co2_Input_Time = Piglet_Co2_Input_Time;
    }
}
