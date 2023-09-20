package pojo;


import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Time;

@Data
@Accessors(chain = true)
public class createdTime {
    Integer CreatorId;
    Time CreatTime;


    @Override
    public String toString() {
        return "\ncreatedTime{" +
                "CreatorId=" + CreatorId +
                ", CreatTime=" + CreatTime +
                '}'+"\n";
    }
}
