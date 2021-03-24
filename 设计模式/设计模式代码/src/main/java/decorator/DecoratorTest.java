package decorator;

/**
 * @Author: chy
 * @Date: 2021/1/15 20:49
 * @Description:
 */
public class DecoratorTest {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        component.operation();
        Component decorator1 = new Decorator1(component);
        decorator1.operation();
        Component decorator2 = new Decorator2(component);
        decorator2.operation();
    }
}

interface Component {
    void operation();
}

class ConcreteComponent implements Component {

    @Override
    public void operation() {
        System.out.println("拍照。");
    }
}

class Decorator1 implements Component {

    Component component;

    public Decorator1(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        System.out.println("美颜。");
        component.operation();
    }
}
class Decorator2 implements Component {

    Component component;

    public Decorator2(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        System.out.println("滤镜。");
        component.operation();
    }
}