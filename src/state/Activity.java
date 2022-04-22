package state;

public interface Activity {
    void justDoIt();
}
class Sleeping implements Activity{
    @Override
    public void justDoIt(){
        System.out.println("Sleeping...");
    }
}
class Coding implements Activity{
    @Override
    public void justDoIt(){
        System.out.println("Coding");
    }
}
class Developer{
    Activity activity;
    public void setActivity(Activity activity){
        this.activity = activity;
    }
    public void changeActivity(){
        if(this.activity instanceof Sleeping){
            this.activity = new Coding();
        }
        else if(this.activity instanceof Coding){
            this.activity = new Sleeping();
        }
    }
    public void justDoIt(){
        this.activity.justDoIt();
        changeActivity();
    }
}
class DevDay{
    public static void main(String[] args){
        Developer developer = new Developer();
        developer.setActivity(new Coding());
        developer.justDoIt();
        developer.justDoIt();
    }
}
