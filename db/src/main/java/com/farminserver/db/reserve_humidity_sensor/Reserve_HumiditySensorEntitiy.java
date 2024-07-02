package com.farminserver.db.reserve_humidity_sensor;

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
@Table(name = "reserve_humidity_sensor")

public class Reserve_HumiditySensorEntitiy extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Reserve_Sows_Room_Num;
    private double Reserve_Humidity_Data;
    private LocalDateTime Reserve_Humidity_Input_Time;

    public String getFarmName() {
        return Reserve_Sows_Room_Num;
    }

    public void setFarmName(String Reserve_Sows_Room_Num) {
        this.Reserve_Sows_Room_Num = Reserve_Sows_Room_Num;
    }


    public double getreserve_HumidityData() {
        return Reserve_Humidity_Data;
    }

    public void setreserve_HumidityData(double Reserve_Humidity_Data) {
        this.Reserve_Humidity_Data = Reserve_Humidity_Data;
    }

    public LocalDateTime getreserve_Humidity_Input_Time() {
        return Reserve_Humidity_Input_Time;
    }

    public void setreserve_Humidity_Input_Time(LocalDateTime Reserve_Humidity_Input_Time) {
        this.Reserve_Humidity_Input_Time = Reserve_Humidity_Input_Time;
    }

}

