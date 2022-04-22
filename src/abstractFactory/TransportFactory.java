//package abstractFactory;
//
//interface Transport{}
//abstract class Car implements Transport{}
//abstract class Ship implements Transport{}
//class Car1 extends Car{}
//class Car2 extends Car{}
//class Ship1 extends Ship{}
//class Ship2 extends Ship{}
//enum TransportType{
//    CAR{
//        public TransportFactory getTransportFactory(){
//            return new CarFactory();
//        }
//    },
//    SHIP{
//        public TransportFactory getTransportFactory(){
//            return new ShipFactory();
//        }
//    };
//    public abstract TransportFactory getTransportFactory();
//}
//enum CarType{
//    CAR1{
//        public Car getCar(){
//            return new Car1();
//        }
//    },
//    CAR2{
//        public Car getCar(){
//            return new Car2();
//        }
//    };
//    public abstract Car getCar();
//}
//enum ShipType{
//    SHIP1{
//        public Ship getShip(){
//            return new Ship1();
//        }
//    },
//    SHIP2{
//        public Ship getShip(){
//            return new Ship2();
//        }
//    };
//    public abstract Ship getShip();
//}
//public interface TransportFactory {
//    Transport getTransport(String transportType);
//}
//class CarFactory implements TransportFactory{
//    public Transport getTransport(String carType){
//        if (carType == CarType.CAR1.name())
//            return CarType.CAR1.getCar();
//        else if (carType == CarType.CAR2.name())
//            return CarType.CAR2.getCar();
//        else return null;
//    }
//}
//class ShipFactory implements  TransportFactory{
//    public Transport getTransport(String shipType){
//        if (shipType == ShipType.SHIP1.name())
//            return ShipType.SHIP1.getShip();
//        else if (shipType == ShipType.SHIP2.name())
//            return ShipType.SHIP2.getShip();
//        else return null;
//    }
//}
//class Main{
//    public static void main(String[] args) {
//        TransportFactory transportFactory = TransportType.SHIP.getTransportFactory();
//        Transport ship = transportFactory.getTransport("SHIP1");
//        System.out.println(ship);
//    }
//}