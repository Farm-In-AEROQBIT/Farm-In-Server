package com.farminserver.api.domain.farm_info.business;

import com.farminserver.db.farm_info.FarmInfoEntity;
import com.farminserver.db.farm_info.FarmInfoRepository;
import org.springframework.stereotype.Component;
import com.farminserver.api.common.annotation.Business;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FarmInfoBusiness {

    private final FarmInfoRepository farmInfoRepository;

    public FarmInfoEntity save(FarmInfoEntity farmInfo) {
        return farmInfoRepository.save(farmInfo);
    }

    public FarmInfoEntity getById(String id) {  // ID 타입을 String으로 변경
        return farmInfoRepository.findById(id).orElse(null);
    }

    public List<FarmInfoEntity> getAll() {  // 메서드 이름 수정
        return farmInfoRepository.findAll();
    }

    public void deleteById(String id) {  // ID 타입을 String으로 변경
        farmInfoRepository.deleteById(id);
    }
}
