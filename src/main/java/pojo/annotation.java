package pojo;


import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class annotation {
    String anName;
    Integer anNum;
    String anIntroduction;


    public annotation(){
        System.out.println("私有构造器");
    }
}
