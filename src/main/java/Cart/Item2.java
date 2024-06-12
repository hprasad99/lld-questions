package Cart;

public class Item2 extends Product{

    Item2(String name, ProductType productType,  double originalPrice) {
        super(name, originalPrice, productType);
    }

    @Override
    public double getPrice() {
        return originalPrice;
    }
}
