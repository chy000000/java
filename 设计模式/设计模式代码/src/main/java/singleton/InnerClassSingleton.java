package singleton;

/**
 * @Author: chy
 * @Date: 2021/1/10 17:53
 * @Description:
 */
public class InnerClassSingleton {

    private static class SingletongHolder {
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }
    private InnerClassSingleton() {

    }

    public static InnerClassSingleton getInstance() {
        return SingletongHolder.instance;
    }

}
