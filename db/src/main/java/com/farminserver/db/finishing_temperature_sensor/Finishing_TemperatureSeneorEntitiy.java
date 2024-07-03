package com.farminserver.db.finishing_temperature_sensor;

import com.farminserver.db.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@EqualsAndHashCode(callSuper = false)
@Data
@SuperBuilder
@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reserve_temperature_sensor")

public class Finishing_TemperatureSeneorEntitiy extends BaseEntity {
     @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private String farmName;
        private double co2Data;
        private LocalDateTime co2InputTime;

    public String getFarmName() { return farmName; }

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
