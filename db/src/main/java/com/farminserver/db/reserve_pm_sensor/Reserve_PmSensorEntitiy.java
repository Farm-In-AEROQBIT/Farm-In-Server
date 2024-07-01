package com.farminserver.db.reserve_pm_sensor;

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

public class Reserve_PmSensorEntitiy extends BaseEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private LocalDateTime

    public String getFarmName() { return farmName; }

    public void setFarmName(String farmName) { this.farmName = farmName; }

    }

}
