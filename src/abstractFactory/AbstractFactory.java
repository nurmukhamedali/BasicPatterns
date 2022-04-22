package abstractFactory;

interface ProductA{}
interface ProductB{}

class SpecificProductA1 implements ProductA{}
class SpecificProductB1 implements ProductB{}

class SpecificProductA2 implements ProductA{}
class SpecificProductB2 implements ProductB{}

public interface AbstractFactory{
    ProductA createProductA();
    ProductB createProductB();
}

class SpecificFactory1 implements AbstractFactory{
    @Override
    public ProductA createProductA() {
        return new SpecificProductA1();
    }

    @Override
    public ProductB createProductB() {
        return new SpecificProductB1();
    }
}
class SpecificFactory2 implements AbstractFactory{
    @Override
    public ProductA createProductA() {
        return new SpecificProductA2();
    }

    @Override
    public ProductB createProductB() {
        return new SpecificProductB2();
    }
}
class Client{
    public static void main(String[] args) {
        AbstractFactory factory = new SpecificFactory1();
        ProductA productA = factory.createProductA();
    }
}