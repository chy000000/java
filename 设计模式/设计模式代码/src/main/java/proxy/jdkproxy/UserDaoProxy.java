package proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: chy
 * @Date: 2021/1/21 19:44
 * @Description:
 */
public class UserDaoProxy implements InvocationHandler {

    private Object obj;

    public UserDaoProxy() {
    }

    public UserDaoProxy(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始事务");
        method.invoke(obj, args);
        System.out.println("结束事务");
        return null;
    }
}
