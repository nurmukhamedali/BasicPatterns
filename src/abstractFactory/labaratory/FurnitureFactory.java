package abstractFactory.labaratory;

import java.util.ArrayList;

interface Chair{}
interface CoffeeTable{}
interface Sofa{}

class VictorianChair implements Chair{}
class ArtDecoChair implements Chair{}
class ModernChair implements Chair{}

class VictorianCoffeeTable implements CoffeeTable{}
class ArtDecoCoffeeTable implements CoffeeTable{}
class ModernCoffeeTable implements CoffeeTable{}

class VictorianSofa implements Sofa{}
class ArtDecoSofa implements Sofa{}
class ModernSofa implements Sofa{}

public interface FurnitureFactory{
    Chair createChair();
    CoffeeTable createCoffeeTable();
    Sofa createSofa();
}
class VictorianFurnitureFactory implements FurnitureFactory{
    ArrayList<Chair> chairs = new ArrayList<>();
    @Override
    public Chair createChair() {
        Chair chair = new VictorianChair();
        this.chairs.add(chair);
        return chair;
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new VictorianCoffeeTable();
    }

    @Override
    public Sofa createSofa() {
        return new VictorianSofa();
    }
}
class ArtDecoFurnitureFactory implements FurnitureFactory{
    @Override
    public Chair createChair() {
        return new ArtDecoChair();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new ArtDecoCoffeeTable();
    }

    @Override
    public Sofa createSofa() {
        return new ArtDecoSofa();
    }
}
class ModernFurnitureFactory implements FurnitureFactory{
    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new ModernCoffeeTable();
    }

    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }
}

class TEST2{
    public static void main(String[] args) {
        FurnitureFactory factory = new ArtDecoFurnitureFactory();

        Chair chair = factory.createChair();

        CoffeeTable coffeeTable = factory.createCoffeeTable();
        System.out.println(coffeeTable.toString());
        factory = new ModernFurnitureFactory();
        coffeeTable = factory.createCoffeeTable();
        System.out.printf(chair.toString() + "\n" + coffeeTable.toString());
    }
}