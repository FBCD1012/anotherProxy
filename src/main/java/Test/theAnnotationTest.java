package Test;

import Mapper.AnnotationMapper;
import Utils.MybatisUtils;
import lombok.SneakyThrows;
import org.apache.ibatis.session.SqlSession;
import pojo.annotation;
import pojo.annotationCreator;


import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class theAnnotationTest {
    @SneakyThrows
    public static void main(String[] args) {
        //验证会话结束传递缓存操作
        try(SqlSession sqlSes= MybatisUtils.setSqlSession(true)) {
            AnnotationMapper mapper = sqlSes.getMapper(AnnotationMapper.class);
                System.out.println(mapper.selectTransaction(1));
        }
    }
}
