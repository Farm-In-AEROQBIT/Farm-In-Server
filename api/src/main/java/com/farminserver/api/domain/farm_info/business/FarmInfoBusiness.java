package com.farminserver.api.domain.farm_info.business;

import com.farminserver.db.farm_info.FarmInfoEntity;
import com.farminserver.db.farm_info.FarmInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.farminserver.api.common.annotation.Business;
import java.util.List;

@Business
@Component
public class FarmInfoBusiness {

    @Autowired
    private FarmInfoRepository farmInfoRepository;

    public FarmInfoEntity save(FarmInfoEntity farmInfo) {
        return farmInfoRepository.save(farmInfo);
    }

    public FarmInfoEntity getById(Long id) {
        return farmInfoRepository.findById(id).orElse(null);
    }

    public List<FarmInfoEntity> findAll() {
        return farmInfoRepository.findAll();
    }
}
