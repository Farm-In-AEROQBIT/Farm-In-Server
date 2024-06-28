package com.farminserver.db.gestation_pm_sensor;

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
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = false)
@Data
@SuperBuilder
@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "gestation_pm_sensor")

public class Gestation_PmSensorEntitiy {
     @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private String farmName;
        private double gestation_pmData;
        private LocalDateTime gestation_pmInputTime;

        public String getFarmName() {
            return farmName;
        }

        public void setFarmName(String farmName) {
            this.farmName = farmName;
        }

        public double getGestationCo2Data() {
            return gestation_pmData;
        }

        public void setGestationCo2Data(double co2Data) {
            this.gestation_pmData = co2Data;
        }

        public LocalDateTime getCo2InputTime() {
            return gestation_pmInputTime;
        }

        public void setCo2InputTime(LocalDateTime co2InputTime) {
            this.gestation_pmInputTime = co2InputTime;
        }

}