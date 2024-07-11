package com.farminserver.db.growing_temperature_sensor;

import com.farminserver.db.growing_temperature_sensor.Growing_TemperatureSensorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Growing_TemperatureSensorRepository extends JpaRepository<Growing_TemperatureSensorEntity, Long >{
}
