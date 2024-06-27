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
@Table(name = "boars_humidity_sensor")
public class Boars_HumiditySensorEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String farm_name;
    private double boars_humidity_data;
    private LocalDateTime boars_humidity_input_time;

    public String getFarmName() {
        return farm_name;
    }

    public void setFarmName(String farm_name) {
        this.farm_name = farm_name;
    }

    public double getboars_HumidityData() {
        return boars_humidity_data;
    }

    public void setboars_HumidityData(double boars_humidity_data) {
        this.boars_humidity_data = boars_humidity_data;
    }

    public LocalDateTime getboars_Humidity_Input_Time() {
        return boars_humidity_input_time;
    }

    public void setboars_Humidity_Input_Time(LocalDateTime boars_humidity_input_time) {
        this.boars_humidity_input_time = boars_humidity_input_time;
    }

}
