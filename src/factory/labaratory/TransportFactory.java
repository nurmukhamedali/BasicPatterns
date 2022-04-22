package factory.labaratory;

interface Transport{}
class Car implements Transport{}
class Ship implements Transport{}
enum TransportType{
    CAR{
        public Transport getTransport(){
            return new Car();
        }
    },
    SHIP{
        public Transport getTransport(){
            return new Ship();
        }
    };
    public abstract Transport getTransport();
}
public class TransportFactory {
    public Transport getTransport(TransportType transportType){
        return transportType.getTransport();
    }
}


