package Cart;

public class Item1 extends Product{

    Item1(String name, ProductType productType, double originalPrice) {
        super(name, originalPrice, productType);
    }

    @Override
    public double getPrice() {
        return originalPrice;
    }
}
