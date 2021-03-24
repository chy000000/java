package singleton;

import java.awt.print.Pageable;

/**
 * @Author: chy
 * @Date: 2021/1/10 16:16
 * @Description:
 */
public class LazySingletonTest {
    public static void main(String[] args) {

    }
}


//懒汉模式
class LazySingleton {

    private volatile static LazySingleton instance;

    private LazySingleton() {

    }

    public static LazySingleton getInstance() {
        if (instance==null) {
            synchronized(LazySingleton.class) {
                if (instance==null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
