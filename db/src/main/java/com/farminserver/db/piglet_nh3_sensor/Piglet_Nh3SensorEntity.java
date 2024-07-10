package com.farminserver.db.piglet_nh3_sensor;

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
@Table(name = "piglet_nh3_sensor")

public class Piglet_Nh3SensorEntity extends BaseEntity {

    private String Piglet_Room_Num;
    private double Piglet_Nh3_Data;
    private LocalDateTime Piglet_Nh3_Input_Time;

    public String getFarmName() {
        return Piglet_Room_Num;
    }

    public void setFarmName(String Piglet_Room_Num) {
        this.Piglet_Room_Num = Piglet_Room_Num;
    }

    public double getpiglet_Nh3Data() {
        return Piglet_Nh3_Data;
    }

    public void setpiglet_Nh3Data(double Piglet_Nh3_Data) {
        this.Piglet_Nh3_Data = Piglet_Nh3_Data;
    }

    public LocalDateTime getpiglet_Nh3InputTime() { return Piglet_Nh3_Input_Time; }

    public void setpiglet_Nh3InputTime(LocalDateTime Piglet_Nh3_Input_Time) {
        this.Piglet_Nh3_Input_Time = Piglet_Nh3_Input_Time;
    }


}
