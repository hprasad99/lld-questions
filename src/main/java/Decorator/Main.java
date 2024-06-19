package Decorator;

public class Main {
    public static void main(String[] args) {
        Coffee myCoffee = new SimpleCoffee();

        System.out.println(myCoffee.getDescrption() + " Cost: Rs" + myCoffee.getCost());

        myCoffee = new MilkCoffeeDecorator(myCoffee);
        System.out.println(myCoffee.getDescrption() + "Cost: Rs" + myCoffee.getCost());
    }
}
