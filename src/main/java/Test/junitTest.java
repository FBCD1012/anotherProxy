package Test;

import Mapper.AnnotationMapper;
import lombok.SneakyThrows;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileReader;

public class junitTest {
    public static SqlSessionFactory sqlSessionFactory;
    public static SqlSession sqlSession;
    @SneakyThrows
    @Before
    public void method1(){
       sqlSessionFactory=new SqlSessionFactoryBuilder().build(new FileReader("SqlSessionXml.xml"));
       sqlSession=sqlSessionFactory.openSession(true);
       System.out.println("参数构建成功");
    }
    @Test
    public void method2(){
        AnnotationMapper mapper = sqlSession.getMapper(AnnotationMapper.class);
        System.out.println(mapper.selectTransaction(1));
    }
    @After
    public void method3() {
        System.out.println("junit方法测试框架结束");
    }
}
