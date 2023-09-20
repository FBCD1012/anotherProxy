package pojo;


import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class annotationCreator {
    String CreatorName;
    Integer CreatorAge;
    Integer anNum;
    Integer CreatorId;

    annotation listAnnotation;
    createdTime createdTime;

    @Override
    public String toString() {
        return "annotationCreator{" +
                "CreatorName='" + CreatorName + '\'' +
                ", CreatorAge=" + CreatorAge +
                ", anNum=" + anNum +
                ", CreatorId=" + CreatorId +
                ", \nlistAnnotation=" + listAnnotation +
                ", \ncreatedTime=" + createdTime +
                '}';
    }
}
