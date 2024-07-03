package com.farminserver.db.finishing_co2_sensor;

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
@Table(name = "finishing_co2_sensor")
public class Finishing_Co2SensorEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Finishing_Barn_Room_Num;
    private double Finishing_Co2_Data;
    private LocalDateTime Finishing_Co2_Input_Time;


    public String getFarmName() {
        return Finishing_Barn_Room_Num;
    }

    public void setFarmName(String Finishing_Barn_Room_Num) {
        this.Finishing_Barn_Room_Num = Finishing_Barn_Room_Num;
    }


    public double getfinishing_Co2Data() {
        return Finishing_Co2_Data;
    }

    public void setfinishing_Co2Data(double Finishing_Co2_Data) {
        this.Finishing_Co2_Data = Finishing_Co2_Data;
    }


    public LocalDateTime getCo2InputTime() {
        return Finishing_Co2_Input_Time;
    }

    public void setCo2InputTime(LocalDateTime Finishing_Co2_Input_Time) {
        this.Finishing_Co2_Input_Time = Finishing_Co2_Input_Time;
    }
}
