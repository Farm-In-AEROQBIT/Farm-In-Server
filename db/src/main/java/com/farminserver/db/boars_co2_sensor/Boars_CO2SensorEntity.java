package com.farminserver.db.boars_co2_sensor;

import com.farminserver.db.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Service;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = false)
@Data
@SuperBuilder
@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "boars_co2_sensor")
public class Boars_CO2SensorEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String farmName;
    private double boars_co2Data;
    private LocalDateTime boars_co2InputTime;

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public double getboars_Co2Data() {
        return boars_co2Data;
    }

    public void setboars_Co2Data(double boars_co2_data) {
        this.boars_co2Data = boars_co2_data;
    }

    public LocalDateTime getboars_co2_InputTime() {
        return boars_co2InputTime;
    }

    public void setCo2InputTime(LocalDateTime co2InputTime) {
        this.boars_co2InputTime = co2InputTime;
    }

}
