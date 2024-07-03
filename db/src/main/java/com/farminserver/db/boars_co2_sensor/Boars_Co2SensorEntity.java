package com.farminserver.db.boars_co2_sensor;

import com.farminserver.db.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Service;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = false)
@Data
@SuperBuilder
@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "boars_co2_sensor")
public class Boars_Co2SensorEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Boars_Barn_Room_Num;
    private double Boars_Co2_Data;
    private LocalDateTime Boars_Co2_Input_Time;

    public String getFarmName() {
        return Boars_Barn_Room_Num;
    }

    public void setFarmName(String Boars_Barn_Room_Num) {
        this.Boars_Barn_Room_Num = Boars_Barn_Room_Num;
    }


    public double getboars_Co2Data() {
        return Boars_Co2_Data;
    }

    public void setboars_Co2Data(double Boars_Co2_Data) {
        this.Boars_Co2_Data = Boars_Co2_Data;
    }


    public LocalDateTime getCo2InputTime() {
        return Boars_Co2_Input_Time;
    }

    public void setCo2InputTime(LocalDateTime Boars_Co2_Input_Time) {
        this.Boars_Co2_Input_Time = Boars_Co2_Input_Time;
    }

}