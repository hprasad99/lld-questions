package Cart;

import java.util.ArrayList;
import java.util.List;

public class TypeCouponDecorator extends CouponDecorator{
    Product product;
    int discountPercentages;
    ProductType productType;
    static List<ProductType> eligibileProductTypes = new ArrayList<>();
    static {
        eligibileProductTypes.add(ProductType.ELECTRONICS);
        eligibileProductTypes.add(ProductType.FURNITURE);
    }

    TypeCouponDecorator(Product product, int discountPercentages, ProductType productType) {
        this.product = product;
        this.discountPercentages = discountPercentages;
        this.productType = productType;
    }


    @Override
    public double getPrice() {
        double price = product.getPrice();
        if(eligibileProductTypes.contains(productType)) {
            return price - (price * discountPercentages)/100;
        }
        return price;
    }
}
