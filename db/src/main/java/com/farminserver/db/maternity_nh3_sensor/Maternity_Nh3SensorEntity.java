package com.farminserver.db.maternity_nh3_sensor;

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
@Table(name = "maternity_nh3_sensor")

public class Maternity_Nh3SensorEntity extends BaseEntity {

    private String Maternity_Room_Num;
    private double Maternity_Nh3_Data;
    private LocalDateTime Maternity_Nh3_Input_Time;

    public String getFarmName() {
        return Maternity_Room_Num;
    }

    public void setFarmName(String Maternity_Room_Num) { this.Maternity_Room_Num = Maternity_Room_Num; }

    public double getmaternity_Nh3Data() {
        return Maternity_Nh3_Data;
    }

    public void setmaternity_Nh3Data(double Maternity_Nh3_Data) {
        this.Maternity_Nh3_Data = Maternity_Nh3_Data;
    }

    public LocalDateTime getmaternity_Nh3InputTime() {
        return Maternity_Nh3_Input_Time;
    }

    public void setmaternity_Nh3InputTime(LocalDateTime Maternity_Nh3_Input_Time) {
        this.Maternity_Nh3_Input_Time = Maternity_Nh3_Input_Time;
    }

}
