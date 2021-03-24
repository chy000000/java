package proxy.gclibproxy;



/**
 * @Author: chy
 * @Date: 2021/1/21 20:05
 * @Description:
 */
public class GclibProxyTest {
    public static void main(String[] args) {
        UserDao target = new UserDao();
        UserDao proxy = (UserDao) new UserDaoProxy(target).getProxyInstance();
        proxy.save();
    }
}

