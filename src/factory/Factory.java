package factory;

interface Product{}
class ConcreteProductA implements Product{}
class ConcreteProductB implements Product{}

abstract class Creator{
     abstract Product factoryMethod();
}
class ConcreteCreatorA extends Creator{
    @Override
    Product factoryMethod() {
        return new ConcreteProductA();
    }
}
class ConcreteCreatorB extends Creator{
    @Override
    Product factoryMethod() {
        return new ConcreteProductB();
    }
}
class Main{
    public static void main(String[] args){
        Creator[] creators = {new ConcreteCreatorA(), new ConcreteCreatorB()};
        for (Creator creator: creators) {
            Product product = creator.factoryMethod();
            System.out.println(product.getClass().getSimpleName());
        }
    }
}