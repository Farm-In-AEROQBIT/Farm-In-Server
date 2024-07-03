package com.farminserver.db.reserve_temperature_sensor;

import com.farminserver.db.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Service;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;


@EqualsAndHashCode(callSuper = false)
@Data
@SuperBuilder
@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "finishing_co2_sensor")

public class Reserve_TemperatureSensorEntitiy extends BaseEntity {
    @Id
    private String Reserve_Sows_Room_Num;
    private double Reserve_Temperature_Data;
    private String Reserve_Temperature_Input_Time;
    private String Reserve_Temperature_Locate;

    // Getters and Setters
    public String getReserveSowsRoomNum() {
        return Reserve_Sows_Room_Num;
    }

    public void setReserveSowsRoomNum(String Reserve_Sows_Room_Num) {
        this.Reserve_Sows_Room_Num = Reserve_Sows_Room_Num;
    }


    public double getReserveTemperData() {
        return Reserve_Temperature_Data;
    }

    public void setReserveTemperData(double Reserve_Temperature_Data) {
        this.Reserve_Temperature_Data = Reserve_Temperature_Data;
    }


    public String getReserveTemperInputTime() {
        return Reserve_Temperature_Input_Time;
    }

    public void setReserveTemperInputTime(String Reserve_Temperature_Input_Time) {
        this.Reserve_Temperature_Input_Time = Reserve_Temperature_Input_Time;
    }


    public String getReserveTemperLocateData() {
        return Reserve_Temperature_Locate;
    }

    public void setReserveTemperLocateData(String Reserve_Temperature_Locate) {
        this.Reserve_Temperature_Locate = Reserve_Temperature_Locate;
    }

}
