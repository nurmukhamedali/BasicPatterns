package strategy;
interface SwimBehavior{
    void swim();
}
class SwimByHand implements SwimBehavior{
    @Override
    public void swim(){
        System.out.println("By Hand");
    }
}
class SwimByBody implements SwimBehavior{
    @Override
    public void swim(){
        System.out.println("By Body");
    }
}
public abstract class Duck{
    SwimBehavior swimBehavior;
    public void swim(){
        swimBehavior.swim();
    }
}
class DonaldDuck extends Duck{
    DonaldDuck(){
        swimBehavior = new SwimByHand();
    }

}
class Main{
    public static void main(String[] args) {
        Duck donaldDuck = new DonaldDuck();
        donaldDuck.swim();
    }
}

////////////////////////////////////////////////////
