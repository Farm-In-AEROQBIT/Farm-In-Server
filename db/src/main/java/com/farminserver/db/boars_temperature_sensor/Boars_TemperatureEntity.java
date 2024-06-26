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
@Table(name = "Temperature_Sensor")
public class Boars_TemperatureEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 온도 수집 데이터
    public double temp_data;
    // 온도 데이터 입력 시간
    public long temp_input_time;
}
