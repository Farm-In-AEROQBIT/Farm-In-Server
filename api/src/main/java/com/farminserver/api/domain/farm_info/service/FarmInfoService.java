package com.farminserver.api.domain.farm_info.service;

import com.farminserver.api.domain.farm_info.business.FarmInfoBusiness;
import com.farminserver.db.farm_info.FarmInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmInfoService {

    @Autowired
    private FarmInfoBusiness farmInfoBusiness;

    public FarmInfoEntity save(FarmInfoEntity farmInfoEntity) {
        return farmInfoBusiness.save(farmInfoEntity);
    }

    public FarmInfoEntity getById(Long id) {
        return farmInfoBusiness.getById(id);
    }

    public List<FarmInfoEntity> findAll() {
        return farmInfoBusiness.getAll();
    }

    public void deleteById(Long id) {
        farmInfoBusiness.deleteById(id);
    }
}
