package Decorator;

public abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee=coffee;
    }

    @Override
    public String getDescrption() {
        return decoratedCoffee.getDescrption();
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }
}
