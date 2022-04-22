package observer;
import java.util.*;
interface Parishioner{
    void handleEvent(List<String> newsFromChurch);
}

class ConcreteChurchParishioner implements Parishioner{
    private String name;

    public ConcreteChurchParishioner(String name) {
        this.name = name;
    }

    @Override
    public void handleEvent(List<String> newsFromChurch) {
        System.out.println("DEER DEER DEER DEER THIS IS A NEWS FOR YOU!\n" + newsFromChurch);
    }
}

public interface Church{
    void registerParishioner(Parishioner parishioner);
    void removeParishioner(Parishioner parishioner);
    void notifyParishioners();
}

class CatholicChurch implements Church{
    List<Parishioner> parishioners;
    List<String> churchNews;

    public CatholicChurch() {
        this.parishioners = new ArrayList<>();
        this.churchNews = new ArrayList<>();
    }

    @Override
    public void registerParishioner(Parishioner parishioner) {
        this.parishioners.add(parishioner);
    }

    @Override
    public void removeParishioner(Parishioner parishioner) {
        this.parishioners.remove(parishioner);
    }

    @Override
    public void notifyParishioners() {
        for (Parishioner p: parishioners) {
            p.handleEvent(this.churchNews);
        }
    }
}
