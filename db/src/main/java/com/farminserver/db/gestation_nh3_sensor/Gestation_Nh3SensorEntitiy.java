package com.farminserver.db.finishing_humidity_sensor;

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
@Table(name = "finishing_co2_sensor")

public class Gestation_Nh3SensorEntitiy {
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

}
