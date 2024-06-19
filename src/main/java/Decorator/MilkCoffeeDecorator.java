package Decorator;

public class MilkCoffeeDecorator extends CoffeeDecorator{
    public MilkCoffeeDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescrption() {
        return decoratedCoffee.getDescrption() + " Milk";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.5;
    }
}
