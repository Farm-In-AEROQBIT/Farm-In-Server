package com.farminserver.db.maternity_hunmidity_sensor;

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
@Table(name = "maternity_humidity_sensor")

public class Maternity_HumiditySensorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Maternity_Room_Num;
    private double Maternity_Humidity_Data;
    private LocalDateTime Maternity_Humidity_Input_Time;

    public String getFarmName() {
        return Maternity_Room_Num;
    }

    public void setFarmName(String Maternity_Room_Num) {
        this.Maternity_Room_Num = Maternity_Room_Num;
    }


    public double getmaternity_HumidityData() {
        return Maternity_Humidity_Data;
    }

    public void setmaternity_HumidityData(double Maternity_Humidity_Data) {
        this.Maternity_Humidity_Data = Maternity_Humidity_Data;
    }

    public LocalDateTime getMaternity_Humidity_Input_Time() {
        return Maternity_Humidity_Input_Time;
    }

    public void setMaternity_Humidity_Input_Time(LocalDateTime Maternity_Humidity_Input_Time) {
        this.Maternity_Humidity_Input_Time = Maternity_Humidity_Input_Time;
    }

}

