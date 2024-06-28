package com.farminserver.db;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.time.LocalDateTime;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Boars Input Time
    private LocalDateTime boars_co2InputTime;
    private LocalDateTime boars_nh3InputTime;
    private LocalDateTime boars_humidityInputTime;
    private LocalDateTime boars_temperatureInputTime;
    private LocalDateTime boars_pmInputTime;
    //Finishing Input Time
    private LocalDateTime finishing_co2InputTime;
    private LocalDateTime finishing_nh3InputTime;
    private LocalDateTime finishing_humidityInputTime;
    private LocalDateTime finishing_temperatureInputTime;
    private LocalDateTime finishing_pmInputTime;
    //Gestation Input Time
    private LocalDateTime gestation_co2InputTime;
    private LocalDateTime gestation_nh3InputTime;
    private LocalDateTime gestation_humidityInputTime;
    private LocalDateTime gestation_temperatureInputTime;
    private LocalDateTime gestation_pmInputTime;
    //Growing Input Time
    private LocalDateTime growing_co2InputTime;
    private LocalDateTime growing_nh3InputTime;
    private LocalDateTime growing_humidityInputTime;
    private LocalDateTime growing_temperatureInputTime;
    private LocalDateTime growing_pmInputTime;
    //Meternity Input Time
    private LocalDateTime maternity_co2InputTime;
    private LocalDateTime maternity_nh3InputTime;
    private LocalDateTime maternity_humidityInputTime;
    private LocalDateTime maternity_temperatureInputTime;
    private LocalDateTime maternity_pmInputTime;
    //Piglet Input Time
    private LocalDateTime piglet_co2InputTime;
    private LocalDateTime piglet_nh3InputTime;
    private LocalDateTime piglet_humidityInputTime;
    private LocalDateTime piglet_temperatureInputTime;
    private LocalDateTime piglet_pmInputTime;
    //Reserve Input Time
    private LocalDateTime reserve_co2InputTime;
    private LocalDateTime reserve_nh3InputTime;
    private LocalDateTime reserve_humidityInputTime;
    private LocalDateTime reserve_temperatureInputTime;
    private LocalDateTime reserve_pmInputTime;

}
