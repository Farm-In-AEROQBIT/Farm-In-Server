package com.farminserver.db.growing_co2_sensor;

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
@Table(name = "growing_co2_sensor")

public class Growing_Co2SensorEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Growing_Room_Num;
    private double Growing_Co2_Data;
    private LocalDateTime Growing_Co2_Input_Time;

    public String getFarmName() {
        return Growing_Room_Num;
    }

    public void setFarmName(String Growing_Room_Num) {
        this.Growing_Room_Num = Growing_Room_Num;
    }


    public double getgrowing_Co2Data() {
        return Growing_Co2_Data;
    }
    public void setgrowing_Co2Data(double Growing_Co2_Data) {
        this.Growing_Co2_Data = Growing_Co2_Data;
    }


    public LocalDateTime getCo2InputTime() {
        return Growing_Co2_Input_Time;
    }

    public void setCo2InputTime(LocalDateTime Growing_Co2_Data) {
        this.Growing_Co2_Input_Time = Growing_Co2_Data;
    }

}

