package proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author: chy
 * @Date: 2021/1/21 19:12
 * @Description:
 */
public class DynamicProxyTest {
    public static void main(String[] args) {
        IUserDao userDao = new UserDao();

        InvocationHandler handler = new UserDaoProxy(userDao);

        IUserDao proxy = (IUserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(), userDao.getClass().getInterfaces(), handler);

        proxy.save();
    }
}

