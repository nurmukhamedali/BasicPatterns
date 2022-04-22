//package state.labaratory;
//
//interface State{
//    void doAction(Context context);
//}
//
//class StartState implements State{
//    @Override
//    public void doAction(Context context) {
//        System.out.println("Start state activated");
//        context.setState(this);
//    }
//    @Override
//    public String toString(){
//        return "Start State";
//    }
//}
//class StopState implements State{
//    @Override
//    public void doAction(Context context) {
//        System.out.println("Stop state activated");
//        context.setState(this);
//    }
//    @Override
//    public String toString(){
//        return "Stop State";
//    }
//}
//
//class Context{
//    private State state;
//    public Context() {
//        this.state = null;
//    }
//    public void setState(State state){
//        this.state = state;
//    }
//    public State getState(){
//        return this.state;
//    }
//}
//public class StatePatternDemo{
//    public static void main(String[] args) {
//        Context context = new Context();
//        State state = new StartState();
//        state.doAction(context);
//        System.out.println(context.getState().toString());
//        state = new StopState();
//        state.doAction(context);
//        System.out.println(context.getState().toString());
//    }
//}
