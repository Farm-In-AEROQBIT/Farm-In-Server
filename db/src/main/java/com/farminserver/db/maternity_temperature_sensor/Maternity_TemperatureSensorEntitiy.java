package com.farminserver.db.maternity_temperature_sensor;

import com.farminserver.db.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Service;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;


@EqualsAndHashCode(callSuper = false)
@Data
@SuperBuilder
@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "maternity_temperature_sensor")

public class Maternity_TemperatureSensorEntitiy extends BaseEntity {
    @Id
    private String Maternity_Barn_Room_Num;
    private double Maternity_Temper_Data;
    private String Maternity_Temper_Input_Time;
    private String Maternity_Temper_Locate_Data;

    // Getters and Setters
    public String getMaternityRoomNum() {
        return Maternity_Barn_Room_Num;
    }

    public void setMaternityRoomNum(String Maternity_Barn_Room_Num) {
        this.Maternity_Barn_Room_Num = Maternity_Barn_Room_Num;
    }


    public double getMaternityTemperData() {
        return Maternity_Temper_Data;
    }

    public void setMaternityTemperData(double Maternity_Temper_Data) {
        this.Maternity_Temper_Data = Maternity_Temper_Data;
    }


    public String getMaternityTemperInputTime() {
        return Maternity_Temper_Input_Time;
    }

    public void setMaternityTemperInputTime(String Maternity_Temper_Input_Time) {
        this.Maternity_Temper_Input_Time = Maternity_Temper_Input_Time;
    }


    public String getMaternityTemperLocateData() {
        return Maternity_Temper_Locate_Data;
    }

    public void setMaternityTemperLocateData(String Maternity_Temper_Locate_Data) {
        this.Maternity_Temper_Locate_Data = Maternity_Temper_Locate_Data;
    }

}