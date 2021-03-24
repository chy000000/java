package abstractfactory;

/**
 * @Author: chy
 * @Date: 2021/1/13 20:25
 * @Description:
 */
public class AbstractFactory {
    public static void main(String[] args) {
        DatabaseUtils databaseUtils = new MysqlUitls();
        IConnection connection = databaseUtils.getConnection();
        connection.connect();
        ICommand command = databaseUtils.getCommand();
        command.command();
        databaseUtils = new OracleUitls();
        connection = databaseUtils.getConnection();
        connection.connect();
        command = databaseUtils.getCommand();
        command.command();
    }
}

//模拟数据库

//规范设计
interface IConnection {
    void connect();
}
interface ICommand {
    void command();
}
interface DatabaseUtils {
    IConnection getConnection();
    ICommand getCommand();
}

//具体实现
class MysqlConnection implements IConnection {

    public void connect() {
        System.out.println("Mysql connected.");
    }
}
class MysqlCommand implements ICommand {
    public void command() {
        System.out.println("Mysql command.");
    }
}
class MysqlUitls implements DatabaseUtils {

    public IConnection getConnection() {
        return new MysqlConnection();
    }

    public ICommand getCommand() {
        return new MysqlCommand();
    }
}


class OracleConnection implements IConnection {

    public void connect() {
        System.out.println("Oracle connected.");
    }
}
class OracleCommand implements ICommand {
    public void command() {
        System.out.println("Oracle command.");
    }
}
class OracleUitls implements DatabaseUtils {

    public IConnection getConnection() {
        return new OracleConnection();
    }

    public ICommand getCommand() {
        return new OracleCommand();
    }
}