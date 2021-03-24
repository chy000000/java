package proxy.staticproxy;

/**
 * @Author: chy
 * @Date: 2021/1/21 18:29
 * @Description:
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        UserDao target = new UserDao();
        UserDaoProxy userDaoProxy = new UserDaoProxy(target);
        userDaoProxy.save();
    }
}

interface IUserDao {
    public void save();
}

class UserDao implements IUserDao {

    @Override
    public void save() {
        System.out.println("保存数据。");
    }
}

class UserDaoProxy implements  IUserDao {

    private IUserDao target;

    public UserDaoProxy(IUserDao target) {
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("开始事务。");
        target.save();
        System.out.println("结束事务。");
    }
}