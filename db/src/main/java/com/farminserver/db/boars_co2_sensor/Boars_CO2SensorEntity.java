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
@Table(name = "Co2_Sensor")
public class Boars_CO2SensorEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String farmName;
    private double co2Data;
    private LocalDateTime co2InputTime;

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public double getCo2Data() {
        return co2Data;
    }

    public void setCo2Data(double co2Data) {
        this.co2Data = co2Data;
    }

    public LocalDateTime getCo2InputTime() {
        return co2InputTime;
    }

    public void setCo2InputTime(LocalDateTime co2InputTime) {
        this.co2InputTime = co2InputTime;
    }

}