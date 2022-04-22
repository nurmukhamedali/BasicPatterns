package observer;
import java.util.*;
interface JobObserver {
    void handleEvent(List<String> vacancies);
}

interface Observed{
    void addObserver(JobObserver observer);
    void removeObserver(JobObserver observer);
    void notifyObservers();
}
class Subscribers implements JobObserver {
    String name;

    public Subscribers(String name) {
        this.name = name;
    }

    @Override
    public void handleEvent(List<String> vacancies) {
        System.out.println("Dear " + name + "\n We have some changes in vacancy list: \n" + vacancies);
        System.out.println("*************************************");
    }
}
class JobSite implements Observed{
    List<JobObserver> subscribers = new ArrayList<>();
    List<String> vacancies = new ArrayList<>();

    public void addVacancy(String vacancy){
        vacancies.add(vacancy);
    }

    public void removeVacancy(String vacancy){
        vacancies.remove(vacancy);
    }

    @Override
    public void addObserver(JobObserver observer) {
        this.subscribers.add(observer);
    }

    @Override
    public void removeObserver(JobObserver observer) {
        this.subscribers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (JobObserver observer: subscribers) {
            observer.handleEvent(this.vacancies);

        }
    }
}
