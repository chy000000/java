package prototype;

/**
 * @Author: chy
 * @Date: 2021/1/14 20:17
 * @Description:
 */
public class PrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        BaseInfo baseInfo = new BaseInfo("chy");
        Product product = new Product("part1", "part2", "part3", "part4", baseInfo);

        Product clone = (Product) product.clone();
        System.out.println(product);
        System.out.println(clone);

    }
}


class BaseInfo implements Cloneable {
    private String name;

    public BaseInfo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.hashCode() + " BaseInfo{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return ((BaseInfo) super.clone());
    }
}

class Product implements Cloneable {
    private String part1;
    private String part2;
    private String part3;
    private String part4;
    private BaseInfo baseInfo;

    public Product(String part1, String part2, String part3, String part4, BaseInfo baseInfo) {
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
        this.part4 = part4;
        this.baseInfo = baseInfo;
    }

    public String getPart1() {
        return part1;
    }

    public void setPart1(String part1) {
        this.part1 = part1;
    }

    public String getPart2() {
        return part2;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }

    public String getPart3() {
        return part3;
    }

    public void setPart3(String part3) {
        this.part3 = part3;
    }

    public String getPart4() {
        return part4;
    }

    public void setPart4(String part4) {
        this.part4 = part4;
    }

    public BaseInfo getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(BaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }

    @Override
    public String toString() {
        return super.hashCode() + " Product{" +
                "part1='" + part1 + '\'' +
                ", part2='" + part2 + '\'' +
                ", part3='" + part3 + '\'' +
                ", part4='" + part4 + '\'' +
                ", baseInfo=" + baseInfo +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Product clone = (Product) super.clone();
        BaseInfo clone1 = (BaseInfo) clone.baseInfo.clone();
        clone.setBaseInfo(clone1);
        return clone;
    }
}