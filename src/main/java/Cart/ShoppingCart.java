package Cart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    List<Product> productList;

    public ShoppingCart() {
        this.productList = new ArrayList<>();
    }

    public void addToCart(Product product) {
        Product productEligibleForDiscount =
                new TypeCouponDecorator(new PercentageCouponDecorator(product, 10), 3, product.getProductType());
        productList.add(productEligibleForDiscount);
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for(Product product: productList) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}
