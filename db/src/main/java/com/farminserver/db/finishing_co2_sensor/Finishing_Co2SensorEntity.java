package com.farminserver.db.finishing_co2_sensor;

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
@Table(name = "finishing_co2_sensor")
public class Finishing_Co2SensorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String farmName;
    private double finishing_co2Data;
    private LocalDateTime finishing_co2InputTime;

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public double getFinishing_Co2Data() {
        return finishing_co2Data;
    }

    public void setFiniishing_Co2Data(double boars_co2_data) {
        this.finishing_co2Data = boars_co2_data;
    }

    public LocalDateTime getfinishing_co2_InputTime() {
        return finishing_co2InputTime;
    }

    public void setCo2InputTime(LocalDateTime co2InputTime) {
        this.finishing_co2InputTime = co2InputTime;
    }

}