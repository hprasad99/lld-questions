package Decorator;

public class SimpleCoffee implements Coffee{
    @Override
    public String getDescrption() {
        return "Simple Coffee";
    }

    @Override
    public double getCost() {
        return 2.0;
    }
}
