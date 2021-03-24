package template;

/**
 * @Author: chy
 * @Date: 2021/1/17 21:30
 * @Description:
 */
public class TemplateTest {
    public static void main(String[] args) {
        Template template = new ConcreteClass();
        template.operation();
    }
}

abstract class Template {
    public void operation() {
        //prepare
        System.out.println("pre ...");
        System.out.println("step1 ...");
        System.out.println("step2 ...");

        templateMethod();
    }
    abstract protected void templateMethod();
}

class ConcreteClass extends Template {

    @Override
    protected void templateMethod() {
        System.out.println("Subclass method");
    }
}
