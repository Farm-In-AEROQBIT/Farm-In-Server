package com.farminserver.api.domain.farm_info.business;

import com.farminserver.db.farm_info.FarmInfoEntity;
import com.farminserver.db.farm_info.FarmInfoRepository;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FarmInfoBusiness {

    private final FarmInfoRepository farmInfoRepository;

    public FarmInfoEntity save(FarmInfoEntity farmInfo) {
        return farmInfoRepository.save(farmInfo);
    }

    public FarmInfoEntity getById(Long id) {
        return farmInfoRepository.findById(id).orElse(null);
    }

    public List<FarmInfoEntity> getAll() {
        return farmInfoRepository.findAll();
    }

    public void deleteById(Long id) {
        farmInfoRepository.deleteById(id);
    }
}
