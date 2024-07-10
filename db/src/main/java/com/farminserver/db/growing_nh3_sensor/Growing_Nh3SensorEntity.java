package com.farminserver.db.growing_nh3_sensor;

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
@Table(name = "growing_nh3_sensor")

public class Growing_Nh3SensorEntity extends BaseEntity {

    private String Growing_Room_Num;
    private double Growing_Nh3_Data;
    private LocalDateTime Growing_Nh3_Input_Time;

    public String getFarmName() {
        return Growing_Room_Num;
    }

    public void setFarmName(String Growing_Room_Num) {
        this.Growing_Room_Num = Growing_Room_Num;
    }


    public double getgrowing_Nh3Data() {
        return Growing_Nh3_Data;
    }

    public void setgrowing_Nh3Data(double growing_Nh3_Data) {
        this.Growing_Nh3_Data = growing_Nh3_Data;
    }

    public LocalDateTime Growing_Humidity_Input_Time() {
        return Growing_Nh3_Input_Time;
    }

    public void setgrowing_Input_Time(LocalDateTime Growing_Nh3_Input_Time) {
        this.Growing_Nh3_Input_Time = Growing_Nh3_Input_Time;
    }

}
