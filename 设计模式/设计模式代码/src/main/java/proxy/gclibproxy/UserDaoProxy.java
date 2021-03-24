package proxy.gclibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: chy
 * @Date: 2021/1/21 20:10
 * @Description:
 */
public class UserDaoProxy implements MethodInterceptor {

    private Object obj;

    public UserDaoProxy(Object obj) {
        this.obj = obj;
    }

    public Object getProxyInstance() {
        //1. 创建一个工具类
        Enhancer enhancer = new Enhancer();
        //2. 设置父类
        enhancer.setSuperclass(obj.getClass());
        //3. 设置回调函数
        enhancer.setCallback(this);
        //4. 创建子类对象，即代理对象
        return enhancer.create();


    }


    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始事务");
        method.invoke(obj, objects);
        System.out.println("结束事务");
        return null;
    }
}
