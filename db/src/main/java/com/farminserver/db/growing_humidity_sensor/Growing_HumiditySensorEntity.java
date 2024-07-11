package com.farminserver.db.growing_humidity_sensor;

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
@Table(name = "growing_humidity_sensor")

public class Growing_HumiditySensorEntity extends BaseEntity {

    private String Growing_Room_Num;
    private double Growing_Humidity_Data;
    private LocalDateTime Growing_Humidity_Input_Time;

    public String getFarmName() {
        return Growing_Room_Num;
    }

    public void setFarmName(String Growing_Room_Num) {
        this.Growing_Room_Num = Growing_Room_Num;
    }


    public double getgrowing_HumidityData() {
        return Growing_Humidity_Data;
    }

    public void setgrowing_HumidityData(double Growing_Humidity_Data) {
        this.Growing_Humidity_Data = Growing_Humidity_Data;
    }

    public LocalDateTime getgrowing_Humidity_Input_Time() {
        return Growing_Humidity_Input_Time;
    }

    public void setgrowing_Humidity_Input_Time(LocalDateTime Growing_Humidity_Input_Time) {
        this.Growing_Humidity_Input_Time = Growing_Humidity_Input_Time;
    }

}
