package com.farminserver.db.boars_nh3_sensor;

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
@Table(name = "boars_nh3_sensor")
public class Maternity_Nh3SensorEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Boars_Barn_Room_Num;
    private double Boars_Nh3_Data;
    private LocalDateTime Boars_Nh3_Input_Time;

    public String getFarmName() {
        return Boars_Barn_Room_Num;
    }

    public void setFarmName(String farmName) { this.Boars_Barn_Room_Num = Boars_Barn_Room_Num; }

    public double getboars_Nh3Data() {
        return Boars_Nh3_Data;
    }

    public void setboars_Nh3Data(double Boars_Nh3_Data) {
        this.Boars_Nh3_Data = Boars_Nh3_Data;
    }

    public LocalDateTime getboars_Nh3InputTime() {
        return Boars_Nh3_Input_Time;
    }

    public void setboars_Nh3InputTime(LocalDateTime Boars_Nh3_Input_Time) {
        this.Boars_Nh3_Input_Time = Boars_Nh3_Input_Time;
    }

}
