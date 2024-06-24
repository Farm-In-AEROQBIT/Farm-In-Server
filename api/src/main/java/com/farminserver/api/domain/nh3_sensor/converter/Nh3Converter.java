package com.farminserver.api.domain.nh3_sensor.converter;

import com.farminserver.api.domain.nh3_sensor.controller.model.Nh3Response;
import com.farminserver.db.nh3_sensor.Nh3SensorEntity;
import org.springframework.stereotype.Component;

@Component
public class Nh3Converter {

    public Nh3Response convert(double nh3) {
        // 데이터 변환 로직 (예: 단위 변환, 타임스탬프 추가 등)
        String unit = "ppm"; // 예시 단위
        long timestamp = System.currentTimeMillis();

        return new Nh3Response(nh3, unit, timestamp);
    }
}
