package Test;

import Interface.impl.theHackerImpl;
import Interface.impl.theProxyHacker;
import Interface.theHacker;

import java.lang.reflect.Proxy;

public class proxyTest {
    public static void main(String[] args) {
        theHackerImpl theHacker=new theHackerImpl();
        theHacker theHacker2=(theHacker) Proxy.newProxyInstance(
                theHacker.getClass().getClassLoader(),
                theHacker.getClass().getInterfaces(),
                new theProxyHacker(theHacker));
        theHacker2.DoIt("董青");
        System.out.println(theHacker2.getClass().getName());
    }
}
