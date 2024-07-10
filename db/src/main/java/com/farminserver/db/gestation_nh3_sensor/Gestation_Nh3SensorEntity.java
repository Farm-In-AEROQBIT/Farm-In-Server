package com.farminserver.db.gestation_nh3_sensor;

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
@Table(name = "gestation_nh3_sensor")

public class Gestation_Nh3SensorEntity extends BaseEntity {

    private String Gestation_Room_Num;
    private double Gestation_Nh3_Data;
    private LocalDateTime Gestation_Nh3_Input_Time;

    public String getFarmName() {
        return Gestation_Room_Num;
    }

    public void setFarmName(String farmName) { this.Gestation_Room_Num = Gestation_Room_Num; }

    public double getgestation_Nh3Data() {
        return Gestation_Nh3_Data;
    }

    public void setgestation_Nh3Data(double Gestation_Nh3_Data) {
        this.Gestation_Nh3_Data = Gestation_Nh3_Data;
    }

    public LocalDateTime getgestation_Nh3InputTime() {
        return Gestation_Nh3_Input_Time;
    }

    public void setgestation_Nh3InputTime(LocalDateTime Gestation_Nh3_Input_Time) {
        this.Gestation_Nh3_Input_Time = Gestation_Nh3_Input_Time;
    }

}

