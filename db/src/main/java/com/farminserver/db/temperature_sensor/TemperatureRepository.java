package com.farminserver.db.temperature_sensor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TemperatureRepository extends JpaRepository<TemperatureEntity, Long >{
}
