package com.farminserver.db.reserve_nh3_sensor;

import com.farminserver.db.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import jakarta.persistence.*;


@EqualsAndHashCode(callSuper = false)
@Data
@SuperBuilder
@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reverse_nh3_sensor")
public class Reserve_Nh3SensorEntitiy extends BaseEntity {
    @Id
    private String reverseSowsRoomNum;
    private String reverseNh3Data;
    private String reverseNh3InputTime;

    public String getReverseSowsRoomNum() { return reverseSowsRoomNum; }

    public void setReverseSowsRoomNum(String reverseSowsRoomNum) {
        this.reverseSowsRoomNum = reverseSowsRoomNum;
    }

    public String getReverseNh3Data() { return reverseNh3Data; }

    public void setReverseNh3Data(String ReverseNh3Data) { this.reverseNh3Data = reverseNh3Data; }

    public String getReverseNh3InputTime() { return reverseNh3InputTime; }

    public void setReverseNh3InputTime(String reverseNh3InputTime) {
        this.reverseNh3InputTime = reverseNh3InputTime;
    }


}
