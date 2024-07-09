package com.farminserver.db.reserve_co2_sensor;

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
@Table(name = "reserve_co2_sensor")

public class Reserve_Co2SensorEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Reserve_Sows_Room_Num;
    private double Reserve_Co2_Data;
    private LocalDateTime Reserve_Co2_Input_Time;

    public String getFarmName() {
        return Reserve_Sows_Room_Num;
    }

    public void setFarmName(String Reserve_Sows_Room_Num) {
        this.Reserve_Sows_Room_Num = Reserve_Sows_Room_Num;
    }


    public double getreserve_Co2Data() {
        return Reserve_Co2_Data;
    }

    public void setreserve_Co2Data(double Reserve_Co2_Data) {
        this.Reserve_Co2_Data = Reserve_Co2_Data;
    }


    public LocalDateTime getCo2InputTime() {
        return Reserve_Co2_Input_Time;
    }

    public void setCo2InputTime(LocalDateTime Reserve_Co2_Input_Time) {
        this.Reserve_Co2_Input_Time = Reserve_Co2_Input_Time;
    }

}
