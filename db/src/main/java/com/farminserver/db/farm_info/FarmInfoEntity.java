package com.farminserver.db.farm_info;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.farminserver.db.BaseEntity;

@Entity
@Table(name = "farm_info")
public class FarmInfoEntity extends BaseEntity {

    private String farm_name;

    //Getters and Setters
    public String getFarm_name() {return farm_name;}
    public void setFarm_name(String farm_name) {this.farm_name = farm_name;}
}
