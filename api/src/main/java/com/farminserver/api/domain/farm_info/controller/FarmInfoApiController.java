package com.farminserver.api.domain.farm_info.controller;

import com.farminserver.api.domain.farm_info.service.FarmInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/farminfo")
public class FarmInfoApiController {

    private long farm_name;

    public long getFarm_name() {
        return farm_name;
    }
    public void setFarm_name(long farmName) {
        this.farm_name = farmName;
    }
}
