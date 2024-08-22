package com.farminserver.db.farm_info;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import com.farminserver.db.BaseEntity;
import com.farminserver.db.user.UserEntity;

import java.util.List;

@Entity
@Table(name = "farm_info")
public class FarmInfoEntity extends BaseEntity {

    private String farmName;

    @OneToMany(mappedBy = "farmInfo")
    @JsonManagedReference
    private List<UserEntity> users;

    // Getters and Setters
    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }
}
