package com.farminserver.db.gestation_nh3_sensor;

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
@Table(name = "gestation_co2_sensor")

public class Gestation_Nh3SensorEntitiy {
     @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private String farmName;
        private double gestation_nh3Data;
        private LocalDateTime gestation_nh3InputTime;

        public String getFarmName() {
            return farmName;
        }

        public void setFarmName(String farmName) {
            this.farmName = farmName;
        }

        public double getGestationNh3Data() {
            return gestation_nh3Data;
        }

        public void setGestationNh3Data(double co2Data) {
            this.gestation_nh3Data = co2Data;
        }

        public LocalDateTime getGestationNh3InputTime() {
            return gestation_nh3InputTime;
        }

        public void setGestationNh3InputTime(LocalDateTime GestationNh3InputTime) {
            this.gestation_nh3InputTime = GestationNh3InputTime;
        }

}
