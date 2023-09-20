package Interface.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class theProxyLogging implements InvocationHandler {
    Object target;

    public theProxyLogging(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target,args);
    }
}
