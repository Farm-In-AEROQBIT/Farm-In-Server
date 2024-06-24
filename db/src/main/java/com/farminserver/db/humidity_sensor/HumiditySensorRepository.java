package com.farminserver.db.humidity_sensor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HumiditySensorRepository extends JpaRepository<HumiditySensorEntity, Long>{
}
