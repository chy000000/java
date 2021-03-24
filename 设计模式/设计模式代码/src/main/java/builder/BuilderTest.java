package builder;

/**
 * @Author: chy
 * @Date: 2021/1/13 21:09
 * @Description:
 */
public class BuilderTest {
    public static void main(String[] args) {
        Product product = new Product.Builder().part1("part1").part2("part2").builder();
        System.out.println(product);
    }
}

class Product {
    private final String part1;
    private final String part2;
    private final String part3;
    private final String part4;

    public Product(String part1, String part2, String part3, String part4) {
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
        this.part4 = part4;
    }

    @Override
    public String toString() {
        return "Product{" +
                "part1='" + part1 + '\'' +
                ", part2='" + part2 + '\'' +
                ", part3='" + part3 + '\'' +
                ", part4='" + part4 + '\'' +
                '}';
    }

    public static class Builder {
        private String part1;
        private String part2;
        private String part3;
        private String part4;

        public Builder part1(String part1) {
            this.part1 = part1;
            return this;
        }
        public Builder part2(String part2) {
            this.part2 = part2;
            return this;
        }
        public Builder part3(String part3) {
            this.part3 = part3;
            return this;
        }
        public Builder part4(String part4) {
            this.part4 = part4;
            return this;
        }

        public Product builder() {
            return new Product(this.part1, this.part2, this.part3, this.part4);
        }
    }
}