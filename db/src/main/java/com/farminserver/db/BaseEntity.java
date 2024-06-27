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
    private Long id;
    private LocalDateTime boars_co2InputTime;
    private LocalDateTime finishing_co2InputTime;
    private LocalDateTime gestation_co2InputTime;
    private LocalDateTime growing_co2InputTime;
    private LocalDateTime maternity_co2InputTime;
    private LocalDateTime piglet_co2InputTime;
    private LocalDateTime reserve_co2InputTime;

}
