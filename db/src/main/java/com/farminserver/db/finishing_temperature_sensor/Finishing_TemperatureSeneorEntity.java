package com.farminserver.db.finishing_temperature_sensor;

import com.farminserver.db.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import jakarta.persistence.*;

@EqualsAndHashCode(callSuper = false)
@Data
@SuperBuilder
@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reserve_temperature_sensor")

public class Finishing_TemperatureSeneorEntity extends BaseEntity {
    @Id
    private String FinishingBarnRoomNum;
    private double FinishingTemperData;
    private LocalDateTime FinishingTemperInputTime;
    private long FinishingTemperLocateData;

    // Getters and Setters
    public String getFinishingBarnRoomNum() {
        return FinishingBarnRoomNum;
    }
    public void setFinishingBarnRoomNum(String FinishingBarnRoomNum) {
        this.FinishingBarnRoomNum = FinishingBarnRoomNum;
    }

    public double getFinishingTemperData() {
        return FinishingTemperData;
    }
    public void setFinishingTemperData(double FinishingTemperData) {
        this.FinishingTemperData = FinishingTemperData;
    }

    public LocalDateTime getFinishingTemperInputTime() {
        return FinishingTemperInputTime;
    }
    public void setFinishingTemperInputTime(LocalDateTime finishingTemperInputTime) {
        this.FinishingTemperInputTime = finishingTemperInputTime;
    }

    public long getFinishingTemperLocateData() {
        return FinishingTemperLocateData;
    }
    public void setFinishingTemperLocateData(long Finishing_Temper_Locate_Data) {
        this.FinishingTemperLocateData = Finishing_Temper_Locate_Data;
    }
}
