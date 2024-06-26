package com.farminserver.db.boars_humidity_sensor;

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
@Table(name = "Humidity_Sensor")
public class Boars_HumiditySensorEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String farm_name;
    private double humidity_data;
    private LocalDateTime humidity_input_time;

    public String getFarmName() {
        return farm_name;
    }

    public void setFarmName(String farm_name) {
        this.farm_name = farm_name;
    }

    public double getHumidityData() {
        return humidity_data;
    }

    public void setHumidityData(double humidity_data) {
        this.humidity_data = humidity_data;
    }

    public LocalDateTime getHumidity_Input_Time() {
        return humidity_input_time;
    }

    public void setHumidity_Input_Time(LocalDateTime humidity_input_time) {
        this.humidity_input_time = humidity_input_time;
    }

}
