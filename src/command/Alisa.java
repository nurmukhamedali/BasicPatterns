package command;

class SmartTV{
    public void on(){
        System.out.println(getClass().getSimpleName() + ": " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
    public void off(){
        System.out.println(getClass().getSimpleName() + ": " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
class SmartVacuum{
    public void start(){
        System.out.println(getClass().getSimpleName() + ": " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
    public void stop(){
        System.out.println(getClass().getSimpleName() + ": " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
class SmartLamp{
    public void switchOn(){
        System.out.println(getClass().getSimpleName() + ": " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
    public void switchOff(){
        System.out.println(getClass().getSimpleName() + ": " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
interface Command{
    void execute();
    void unExecute();
}
class CommandTV implements Command{
    SmartTV tv;
    public CommandTV(SmartTV tv) {
        this.tv = tv;
    }
    @Override
    public void execute() {
        this.tv.on();
    }

    @Override
    public void unExecute() {
        this.tv.off();
    }
}
class CommandVacuum implements Command{
    SmartVacuum vacuum;
    public CommandVacuum(SmartVacuum vacuum) {
        this.vacuum = vacuum;
    }
    @Override
    public void execute() {
        this.vacuum.start();
    }

    @Override
    public void unExecute() {
        this.vacuum.stop();
    }
}
class CommandLamp implements Command{
    SmartLamp lamp;
    public CommandLamp(SmartLamp lamp) {
        this.lamp = lamp;
    }
    @Override
    public void execute() {
        this.lamp.switchOn();
    }

    @Override
    public void unExecute() {
        this.lamp.switchOff();
    }
}
public class Alisa {
    Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void sayStart(){
        this.command.execute();
    }
    public void sayStop(){
        this.command.unExecute();
    }
}
class Main{
    public static void main(String[] args) {
        Alisa alisa = new Alisa();
        alisa.setCommand(new CommandTV(new SmartTV()));
        alisa.sayStart();
        alisa.sayStop();
        alisa.setCommand(new CommandVacuum(new SmartVacuum()));
        alisa.sayStart();
        alisa.sayStop();
        alisa.setCommand(new CommandLamp(new SmartLamp()));
        alisa.sayStart();
        alisa.sayStop();
    }
}