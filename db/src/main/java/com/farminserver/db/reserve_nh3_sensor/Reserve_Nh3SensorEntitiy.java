package com.farminserver.db.reserve_nh3_sensor;

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
@Table(name = "reserve_nh3_sensor")

public class Reserve_Nh3SensorEntitiy extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Reserve_Sows_Room_Num;
    private double Reserve_Nh3_Data;
    private LocalDateTime Reserve_Nh3_Input_Time;

    public String getFarmName() {
        return Reserve_Sows_Room_Num;
    }

    public void setFarmName(String Reserve_Sows_Room_Num) { this.Reserve_Sows_Room_Num = Reserve_Sows_Room_Num; }

    public double getreserve_Nh3Data() {
        return Reserve_Nh3_Data;
    }

    public void setreserve_Nh3Data(double Reserve_Nh3_Data) {
        this.Reserve_Nh3_Data = Reserve_Nh3_Data;
    }

    public LocalDateTime getreserve_Nh3InputTime() {
        return Reserve_Nh3_Input_Time;
    }

    public void setreserve_Nh3InputTime(LocalDateTime Reserve_Nh3_Input_Time) {
        this.Reserve_Nh3_Input_Time = Reserve_Nh3_Input_Time;
    }

}

