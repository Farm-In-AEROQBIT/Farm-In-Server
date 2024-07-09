package com.farminserver.db.piglet_humidity_sensor;

import com.farminserver.db.BaseEntity;
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
@Table(name = "piglet_humidity_sensor")

public class Piglet_HumiditySensorEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Piglet_Room_Num;
    private double Piglet_Humidity_Data;
    private LocalDateTime Piglet_Humidity_Input_Time;

    public String getFarmName() {
        return Piglet_Room_Num;
    }

    public void setFarmName(String Piglet_Room_Num) {
        this.Piglet_Room_Num = Piglet_Room_Num;
    }


    public double getpiglet_HumidityData() { return Piglet_Humidity_Data; }

    public void setpiglet_HumidityData(double Piglet_Humidity_Data) {
        this.Piglet_Humidity_Data = Piglet_Humidity_Data;
    }


    public LocalDateTime getpiglet_Humidity_Input_Time() { return Piglet_Humidity_Input_Time; }

    public void setpiglet_Humidity_Input_Time(LocalDateTime Piglet_Humidity_Input_Time) {
        this.Piglet_Humidity_Input_Time = Piglet_Humidity_Input_Time;
    }

}


