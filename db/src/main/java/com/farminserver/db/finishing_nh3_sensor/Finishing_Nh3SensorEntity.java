package com.farminserver.db.finishing_nh3_sensor;

import com.farminserver.db.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@EqualsAndHashCode(callSuper = false)
@Data
@SuperBuilder
@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "finishing_nh3_sensor")
public class Finishing_Nh3SensorEntity extends BaseEntity {
     @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private String Finishing_Room_Num;
        private double Finishing_Nh3_Data;
        private LocalDateTime Finishing_Nh3_Input_Time;

        public String getFarmName() {
            return Finishing_Room_Num;
        }

        public void setFarmName(String Finishing_Room_Num) {
            this.Finishing_Room_Num = Finishing_Room_Num;
        }

        public double getfinishimg_Nh3Data() {
            return Finishing_Nh3_Data;
        }

        public void setfinishimg_Nh3Data(double Finishing_Nh3_Data) {
            this.Finishing_Nh3_Data = Finishing_Nh3_Data;
        }

        public LocalDateTime getfinishing_Nh3InputTime() { return Finishing_Nh3_Input_Time; }

        public void setfinishing_Nh3InputTime(LocalDateTime Finishing_Nh3_Input_Time) {
            this.Finishing_Nh3_Input_Time = Finishing_Nh3_Input_Time;
        }


}
