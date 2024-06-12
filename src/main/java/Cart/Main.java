package Cart;

public class Main {
    public static void main(String[] args) {
        Product item1 = new Item1("FAN", ProductType.ELECTRONIC, 1000);
        Product item2 = new Item2("SOFA", ProductType.DECORATIVE, 2000);
        ShoppingCart cart = new ShoppingCart();
        cart.addToCart(item1);
        cart.addToCart(item2);

        System.out.println("total price after discount: " + cart.getTotalPrice());
    }
}
