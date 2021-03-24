package singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author: chy
 * @Date: 2021/1/10 17:40
 * @Description:
 */
public class HungrySingleton implements Serializable {

    private final long serialVersionUID = -214092149;

    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {
        if (instance!=null) {
           throw new RuntimeException("单例不允许多个实例");
        }
    }

    public static HungrySingleton getInstance() {
        return instance;
    }

    Object readResolve() throws ObjectStreamException {
        return getInstance();
    }
}

class HungrySingletonTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<HungrySingleton> declareConstructor = HungrySingleton.class.getDeclaredConstructor();
        declareConstructor.setAccessible(true);
        HungrySingleton hungrySingleton = declareConstructor.newInstance();


    }
}
