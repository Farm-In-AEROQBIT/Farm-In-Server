package com.farminserver.db.boars_temperature_sensor;

import com.farminserver.db.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Service;


@EqualsAndHashCode(callSuper = false)
@Data
@SuperBuilder
@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "boars_temperature_sensor")
public class
Boars_TemperatureSeneorEntity extends BaseEntity {
    @Id
    private String boarsBarnRoomNum;

    private String boarsTemperData;
    private String boarsTemperInputTime;
    private String boarsTemperLocateData;

    // Getters and Setters
    public String getBoarsBarnRoomNum() {
        return boarsBarnRoomNum;
    }

    public void setBoarsBarnRoomNum(String boarsBarnRoomNum) {
        this.boarsBarnRoomNum = boarsBarnRoomNum;
    }

    public String getBoarsTemperData() {
        return boarsTemperData;
    }

    public void setBoarsTemperData(String boarsTemperData) {
        this.boarsTemperData = boarsTemperData;
    }

    public String getBoarsTemperInputTime() {
        return boarsTemperInputTime;
    }

    public void setBoarsTemperInputTime(String boarsTemperInputTime) {
        this.boarsTemperInputTime = boarsTemperInputTime;
    }

    public String getBoarsTemperLocateData() {
        return boarsTemperLocateData;
    }

    public void setBoarsTemperLocateData(String boarsTemperLocateData) {
        this.boarsTemperLocateData = boarsTemperLocateData;
    }

}
