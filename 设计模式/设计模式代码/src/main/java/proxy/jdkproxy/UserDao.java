package proxy.jdkproxy;

/**
 * @Author: chy
 * @Date: 2021/1/21 19:44
 * @Description:
 */
public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("保存数据。");
    }
}
