package Interface.impl;

import Interface.theHacker;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class theProxyHacker implements InvocationHandler {
    public Object target;

    public theProxyHacker(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String theRealMan=(String)args[0];
        System.out.println("junction:你是黑客吗?");
        System.out.println(theRealMan+"：我应该不是");
        System.out.println("junction: 那你来参加干嘛？");
        System.out.println(theRealMan+"：我来增长见识");
        return method.invoke(target, args);
    }
}
