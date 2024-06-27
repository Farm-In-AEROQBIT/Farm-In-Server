package com.farminserver.db.boars_temperature_sensor;

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
@Table(name = "boars_temperature_sensor")
public class Boars_TemperatureEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //농장 이름
    public String farmName;
    // 온도 수집 데이터
    public double boars_temp_data;
    // 온도 데이터 입력 시간
    public LocalDateTime boars_temp_input_time;
    //온도 센서 위치 값
    public String boars_temp_locate_data;


    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public double getboars_temp_data() {
        return boars_temp_data;
    }

    public void setboars_temp_data(double Boars_Temp_Data) {
        this.boars_temp_data = Boars_Temp_Data;
    }

    public LocalDateTime getboars_TempInputTime() {
        return boars_temp_input_time;
    }

    public void setboars_TempInputTime(LocalDateTime Boars_TempInputTime) {
        this.boars_temp_input_time = Boars_TempInputTime;
    }

    public String getBoars_TempLocateData() {
        return boars_temp_locate_data;
    }

    public void setBoars_TempLocateData(String Boars_TempLocateData) {
        this.boars_temp_locate_data = Boars_TempLocateData;
    }

}
