package Cart;

public abstract class Product {
    String name;
    double originalPrice;
    ProductType productType;

    Product() {};

    Product(String name, double price, ProductType productType) {
        this.name = name;
        this.originalPrice = price;
        this.productType = productType;
    }

    public abstract double getPrice();

    public ProductType getProductType() {
        return productType;
    }
}
