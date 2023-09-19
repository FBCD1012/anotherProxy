package Utils;

import com.mysql.cj.Session;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileReader;

public class MybatisUtils {
     static SqlSessionFactory sqlSessionFactory;
     static {
         try {
             sqlSessionFactory=new SqlSessionFactoryBuilder().build(new FileReader("SqlSessionXml.xml"));
         }catch (Exception e) {
             e.printStackTrace();
         }
     }
     public static SqlSession setSqlSession(boolean isSet){
         return sqlSessionFactory.openSession(isSet);
     }
}
