package com.farminserver.db.nh3_sensor;

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
@Table(name = "Nh3_Sensor")
public class Nh3SensorEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String farmName;
    private double nh3Data;
    private LocalDateTime nh3InputTime;

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public double getNh3Data() {
        return nh3Data;
    }

    public void setNh3Data(double nh3Data) {
        this.nh3Data = nh3Data;
    }

    public LocalDateTime getNh3InputTime() {
        return nh3InputTime;
    }

    public void setNh3InputTime(LocalDateTime nh3InputTime) {
        this.nh3InputTime = nh3InputTime;
    }

}
