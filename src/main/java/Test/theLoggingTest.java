package Test;

import Interface.impl.theLoggingImpl;
import Interface.impl.theProxyLogging;
import Interface.theLoggingInterface;
import Mapper.UserInfoMapper;
import Utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import pojo.UserInfo;

import java.lang.reflect.Proxy;

public class theLoggingTest {
    public static void main(String[] args) {
        theLoggingImpl theLogging=new theLoggingImpl();
        theLoggingInterface theLoggingInterface=(theLoggingInterface) Proxy.newProxyInstance(
                theLogging.getClass().getClassLoader(),
                theLogging.getClass().getInterfaces(),
                new theProxyLogging(theLogging));
        System.out.println(theLoggingInterface.checkUserInfo("dongqing", "fbcd@dq1012"));
        System.out.println(theLoggingInterface.getClass().getName());
    }
}
