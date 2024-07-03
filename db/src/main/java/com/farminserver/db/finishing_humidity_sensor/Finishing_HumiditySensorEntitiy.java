package com.farminserver.db.finishing_humidity_sensor;

import com.farminserver.db.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@EqualsAndHashCode(callSuper = false)
@Data
@SuperBuilder
@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "finishing_humidity_sensor")

public class Finishing_HumiditySensorEntitiy extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Finishing_Barn_Room_Num;
    private double Finishing_Humidity_Data;
    private LocalDateTime Finishing_Humidity_Input_Time;

    public String getFarmName() {
            return Finishing_Barn_Room_Num;
        }

    public void setFarmName(String Finishing_Barn_Room_Num) {
        this.Finishing_Barn_Room_Num = Finishing_Barn_Room_Num;
    }


    public double getfinishing_HumidityData() { return Finishing_Humidity_Data; }

    public void setfinishing_HumidityData(double Finishing_Humidity_Data) {
        this.Finishing_Humidity_Data = Finishing_Humidity_Data;
    }


    public LocalDateTime getfinishing_Humidity_Input_Time() { return Finishing_Humidity_Input_Time; }

    public void setfinishing_Humidity_Input_Time(LocalDateTime Finishing_Humidity_Input_Time) {
        this.Finishing_Humidity_Input_Time = Finishing_Humidity_Input_Time;
    }

}

