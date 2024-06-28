package com.farminserver.db.gestation_humidity_sensor;

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


@EqualsAndHashCode(callSuper = false)
@Data
@SuperBuilder
@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "gestation_humidity_sensor")

public class Gestation_HumiditySensorEntitiy {
     @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private String farmName;
        private double gestation_humidityData;
        private LocalDateTime gestation_humidityInputTime;

        public String getFarmName() {
            return farmName;
        }

        public void setFarmName(String farmName) {
            this.farmName = farmName;
        }

        public double getGestation_HumidityData() {
            return gestation_humidityData;
        }

        public void setGestation_HumidityData(double co2Data) {
            this.gestation_humidityData = co2Data;
        }

        public LocalDateTime getGestation_HumidityInputTime() {
            return gestation_humidityInputTime;
        }

        public void setGestation_humidityData(LocalDateTime Gestation_HumidityInputTime) {
            this.gestation_humidityInputTime = Gestation_HumidityInputTime;
        }

}
