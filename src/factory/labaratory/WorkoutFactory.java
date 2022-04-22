package factory.labaratory;

interface Workout{
    void createWorkout();
}
class UpperBody implements Workout{
    @Override
    public void createWorkout() {
        System.out.println("Doing upper body");
    }
}
class LowerBody implements Workout{
    @Override
    public void createWorkout() {
        System.out.println("Doing lower body");
    }
}
enum WorkoutType{
    UPPERBODY{
        public Workout getWorkout(){
            return new UpperBody();
        }
    },
    LOWERBODY{
        public Workout getWorkout(){
            return new LowerBody();
        }
    };
    public abstract Workout getWorkout();
}
public class WorkoutFactory{
    public Workout getWorkout(WorkoutType type){

        return type.getWorkout();
    }
}
class W{
    public static void main(String[] args) {
        WorkoutFactory factory = new WorkoutFactory();
        factory.getWorkout(WorkoutType.LOWERBODY);
    }
}