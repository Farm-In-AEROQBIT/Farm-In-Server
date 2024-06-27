package com.farminserver.db.boars_nh3_sensor;

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
@Table(name = "boars_nh3_sensor")
public class Boars_Nh3SensorEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String farmName;
    private double boars_nh3Data;
    private LocalDateTime boars_nh3InputTime;

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public double getboars_Nh3Data() {
        return boars_nh3Data;
    }

    public void setboars_Nh3Data(double boars_nh3Data) {
        this.boars_nh3Data = boars_nh3Data;
    }

    public LocalDateTime getboars_Nh3InputTime() {
        return boars_nh3InputTime;
    }

    public void setboars_Nh3InputTime(LocalDateTime boars_nh3InputTime) {
        this.boars_nh3InputTime = boars_nh3InputTime;
    }

}
