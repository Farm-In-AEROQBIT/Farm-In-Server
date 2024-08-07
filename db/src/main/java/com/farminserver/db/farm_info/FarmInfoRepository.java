package com.farminserver.db.farm_info;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface FarmInfoRepository extends JpaRepository<FarmInfoEntity, Long> {
    Optional<FarmInfoEntity> findById(Long id);
}
