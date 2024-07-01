package com.farminserver.db.growing_temperature_sensor;

import com.farminserver.db.finishing_humidity_sensor.Reserve_TemperatureSensorEntitiy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Growing_TemperatureSensorRepository extends JpaRepository<Reserve_TemperatureSensorEntitiy, Long >{
}
