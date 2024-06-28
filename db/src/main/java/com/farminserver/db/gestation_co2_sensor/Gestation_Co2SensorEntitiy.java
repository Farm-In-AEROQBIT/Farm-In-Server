package com.farminserver.db.gestation_co2_sensor;

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
@Table(name = "gestation_co2_sensor")

public class Gestation_Co2SensorEntitiy {
     @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private String farmName;
        private double gestationco2Data;
        private LocalDateTime gestationco2InputTime;

        public String getFarmName() {
            return farmName;
        }

        public void setFarmName(String farmName) {
            this.farmName = farmName;
        }

        public double getGestationCo2Data() {
            return gestationco2Data;
        }

        public void seGestationtCo2Data(double co2Data) {
            this.gestationco2Data = co2Data;
        }

        public LocalDateTime getGestationCo2InputTime() {
            return gestationco2InputTime;
        }

        public void setGestationCo2InputTime(LocalDateTime Gestationco2InputTime) {
            this.gestationco2InputTime = Gestationco2InputTime;
        }

}
