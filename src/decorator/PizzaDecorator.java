package decorator;

abstract class Pizza{
    protected String name = "";
    public Pizza(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double cost();
}
class PepperoniPizza extends Pizza{
    public PepperoniPizza() {
        super("Pepperoni Pizza");
    }

    @Override
    public double cost(){
        return 1000;
    }
}
class ItalianPizza extends Pizza{
    public ItalianPizza() {
        super("Italian Pizza");
    }

    @Override
    public double cost(){
        return 1500;
    }
}
abstract class PizzaDecorator extends Pizza{
    Pizza pizza;
    public PizzaDecorator(String name, Pizza pizza) {
        super(name);
        this.pizza = pizza;
    }
}
class CheeseDecorator extends PizzaDecorator {
    private static String name = "Cheese";
    public CheeseDecorator(Pizza pizza) {
        super(pizza.getName()+ ", " + name , pizza);
    }

    @Override
    public double cost() {
        return 100 + pizza.cost();
    }
}
class TomatoDecorator extends PizzaDecorator {
    private static String name = "Tomato";
    public TomatoDecorator(Pizza pizza) {
        super(pizza.getName()+ ", " + name , pizza);
    }

    @Override
    public double cost() {
        return 200 + pizza.cost();
    }
}
class Main{
    public static void main(String[] args) {
        Pizza pizza = new ItalianPizza();
        pizza = new CheeseDecorator(pizza);
        pizza = new CheeseDecorator(pizza);
        pizza = new TomatoDecorator(pizza);

        System.out.println(pizza.getName() + " : " + pizza.cost());
    }
}