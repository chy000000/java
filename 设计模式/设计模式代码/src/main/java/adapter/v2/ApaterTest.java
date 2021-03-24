package adapter.v2;

/**
 * @Author: chy
 * @Date: 2021/1/15 20:29
 * @Description:
 */
public class ApaterTest {
    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        adapter.output5v();
    }
}

class Adaptee {
    public int output() {
        return 200;
    }
}

interface Target {
    int output5v();
}

//Class Adapter
class Adapter extends Adaptee implements Target {

    @Override
    public int output5v() {
        int i = output();
        //...
        System.out.println(String.format("Original v : %d , output v : %d .", i, 5));
        return 5;
    }
}