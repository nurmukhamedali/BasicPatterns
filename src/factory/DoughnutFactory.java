package factory;

interface Doughnut{
    void eat();
}
class CherryDoughnut implements Doughnut{
    @Override
    public void eat(){
        System.out.println("You're eating cherry doughnut!");
    }
}
class ChocolateDoughnut implements Doughnut{
    @Override
    public void eat(){
        System.out.println("You're eating chocolate doughnut!");
    }
}
class AlmondDoughnut implements Doughnut{
    @Override
    public void eat(){
        System.out.println("You're eating almond doughnut!");
    }
}

enum DoughnutType{
    CHERRY{
        public Doughnut getDoughnut(){
            return new CherryDoughnut();
        }
    },
    CHOCOLATE{
        public Doughnut getDoughnut(){
            return new ChocolateDoughnut();
        }
    },
    ALMOND{
        public Doughnut getDoughnut(){
            return new AlmondDoughnut();
        }
    };
    public abstract Doughnut getDoughnut();
}
public class DoughnutFactory{
    public Doughnut getDoughnut(DoughnutType type){
        return type.getDoughnut();
    }
}

class Run{
    public static void main(String[] args) {
//        Doughnut doughnut = new DoughnutFactory().getDoughnut(DoughnutType.ALMOND);
//        doughnut.eat();
        DoughnutType.CHOCOLATE.getDoughnut().eat();
    }
}