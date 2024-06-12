package Cart;

public class Main {
    public static void main(String[] args) {
        Product item = new Item("FAN", 1000, ProductType.ELECTRONICS);
        Product item1 = new Item("FAN-1", 2000, ProductType.ELECTRONICS);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addToCart(item);
        shoppingCart.addToCart(item1);

        System.out.println("Total Price: "+ shoppingCart.getTotalPrice());
    }
}
