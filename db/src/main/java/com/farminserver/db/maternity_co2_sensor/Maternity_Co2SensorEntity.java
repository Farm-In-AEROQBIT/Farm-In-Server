package com.farminserver.db.maternity_co2_sensor;

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
@Table(name = "maternity_co2_sensor")

public class Maternity_Co2SensorEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Maternity_Room_Num;
    private double Maternity_Co2_Data;
    private LocalDateTime Maternity_Co2_Input_Time;

    public String getFarmName() {
        return Maternity_Room_Num;
    }

    public void setFarmName(String Maternity_Room_Num) {
        this.Maternity_Room_Num = Maternity_Room_Num;
    }


    public double getmaternity_Co2Data() {
        return Maternity_Co2_Data;
    }

    public void setmaternity_Co2Data(double Maternity_Co2_Data) {
        this.Maternity_Co2_Data = Maternity_Co2_Data;
    }


    public LocalDateTime getCo2InputTime() {
        return Maternity_Co2_Input_Time;
    }

    public void setCo2InputTime(LocalDateTime Maternity_Co2_Input_Time) {
        this.Maternity_Co2_Input_Time = Maternity_Co2_Input_Time;
    }

}

