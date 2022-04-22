package abstractFactory.labaratory;

enum CarType{
    SMALL, SEDAN, LUXURY
}
enum Location{
    DEFAULT, ASIA, USA
}
class Car{
    private CarType model;
    private Location location;

    public Car(CarType model, Location location) {
        this.model = model;
        this.location = location;
    }

    public CarType getModel() {
        return model;
    }

    public void setModel(CarType model) {
        this.model = model;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model=" + model +
                ", location=" + location +
                '}';
    }
}
class LuxuryCar extends Car{
    public LuxuryCar(Location location) {
        super(CarType.LUXURY, location);
    }
}
class SedanCar extends Car{
    public SedanCar(Location location) {
        super(CarType.SEDAN, location);
    }
}
class SmallCar extends Car{
    public SmallCar(Location location) {
        super(CarType.SMALL, location);
    }
}
interface CarFactory{
    Car buildCar(CarType model);
}
class DefaultCarFactory implements CarFactory{
    @Override
    public Car buildCar(CarType model) {
        Car car;
        switch (model) {
            case SMALL:
                car = new SmallCar(Location.DEFAULT);
                break;
            case SEDAN:
                car = new SedanCar(Location.DEFAULT);
                break;
            case LUXURY:
                car = new LuxuryCar(Location.DEFAULT);
                break;
            default:
                return null;
        }
        return car;
    }
}
class AsiaCarFactory implements CarFactory{
    @Override
    public Car buildCar(CarType model) {
        Car car;
        switch (model) {
            case SMALL:
                car = new SmallCar(Location.ASIA);
                break;
            case SEDAN:
                car = new SedanCar(Location.ASIA);
                break;
            case LUXURY:
                car = new LuxuryCar(Location.ASIA);
                break;
            default:
                return null;
        }
        return car;
    }
}
class USACarFactory implements CarFactory{
    @Override
    public Car buildCar(CarType model) {
        Car car;
        switch (model) {
            case SMALL:
                car = new SmallCar(Location.USA);
                break;
            case SEDAN:
                car = new SedanCar(Location.USA);
                break;
            case LUXURY:
                car = new LuxuryCar(Location.USA);
                break;
            default:
                return null;
        }
        return car;
    }
}
class TEST1{
    public static void main(String[] args) {
        Car c = new AsiaCarFactory().buildCar(CarType.LUXURY);
        System.out.println(c.toString());
    }
}