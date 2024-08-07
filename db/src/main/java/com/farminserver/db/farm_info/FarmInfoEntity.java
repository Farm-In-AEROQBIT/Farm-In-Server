package com.farminserver.db.farm_info;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import com.farminserver.db.BaseEntity;

@Entity
@Table(name = "farm_info")
public class FarmInfoEntity extends BaseEntity {

    private String farmName;

    // Getters and Setters
    public String getFarmName() { return farmName; }
    public void setFarmName(String farmName) { this.farmName = farmName; }
}
