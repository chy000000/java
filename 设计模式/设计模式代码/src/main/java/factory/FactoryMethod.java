package factory;

/**
 * @Author: chy
 * @Date: 2021/1/13 20:08
 * @Description:
 */
public class FactoryMethod {
    public static void main(String[] args) {
        Factory application = new ConcreteProductA();
        Product product = application.getObject();
        product.method();
        application = new ConcreteProductA1();
        product = application.getObject();
        product.method();
    }
}

interface Product {
    public void method();
}

class ProductA implements Product {

    public void method() {
        System.out.println("ProductA.method.");;
    }
}

class ProductA1 implements Product {

    public void method() {
        System.out.println("ProductA1.method.");;
    }
}

abstract class Factory {
    abstract Product createProduct();

    public Product getObject() {
        Product product = createProduct();
        return product;
    }
}

class ConcreteProductA extends Factory {

    Product createProduct() {
        return new ProductA();
    }
}

class ConcreteProductA1 extends Factory {

    Product createProduct() {
        return new ProductA1();
    }
}
