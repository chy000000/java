package adapter.v1;

/**
 * @Author: chy
 * @Date: 2021/1/15 20:23
 * @Description:
 */
public class AdapterTest {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target target = new Adapter(adaptee);
        target.output5v();
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

//Object Adapter
class Adapter implements Target {

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public int output5v() {
        int i = adaptee.output();
        //...
        System.out.println(String.format("Original v : %d , output v : %d .", i, 5));
        return 5;
    }
}