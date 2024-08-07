package com.farminserver.api.domain.farm_info.controller;

import com.farminserver.api.domain.farm_info.service.FarmInfoService;
import com.farminserver.api.domain.farm_info.controller.model.FarmInfoResponse;
import com.farminserver.api.domain.farm_info.converter.FarmInfoConverter;
import com.farminserver.db.farm_info.FarmInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/farminfo")
public class FarmInfoApiController {

    @Autowired
    private FarmInfoService farmInfoService;

    @Autowired
    private FarmInfoConverter farmInfoConverter;

    @GetMapping("/{id}")
    public FarmInfoResponse getFarmInfoById(@PathVariable Long id) {
        FarmInfoEntity farmInfoEntity = farmInfoService.getById(id);
        return farmInfoConverter.toResponse(farmInfoEntity);
    }

    @GetMapping("/all")
    public List<FarmInfoResponse> getAllFarmInfos() {
        List<FarmInfoEntity> farmInfoEntities = farmInfoService.findAll();
        return farmInfoEntities.stream()
                .map(farmInfoConverter::toResponse)
                .collect(Collectors.toList());
    }

    @PostMapping("/save")
    public FarmInfoResponse saveFarmInfo(@RequestBody FarmInfoEntity farmInfoEntity) {
        FarmInfoEntity savedFarmInfo = farmInfoService.save(farmInfoEntity);
        return farmInfoConverter.toResponse(savedFarmInfo);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFarmInfoById(@PathVariable Long id) {
        farmInfoService.deleteById(id);
    }
}
