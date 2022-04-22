package observer.labaratory;

import java.util.ArrayList;
import java.util.List;

interface Customer {
    void update(String message);
}
class ConcreteCustomer implements Customer {
    private String name = null;
    public ConcreteCustomer(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("Hey, " + this.name + "! There is some news from Store" + message);
    }
}
interface Administrator {
    void addCustomer(Customer c);
    void removeCustomer(Customer c);
    void notifyCustomers();
}

class Store implements Administrator {
    private List<Customer> customers = new ArrayList<>();
    private String news;
    {
        news = "";
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    @Override
    public void addCustomer(Customer c) {
        this.customers.add(c);
    }

    @Override
    public void removeCustomer(Customer c) {
        this.customers.remove(c);
    }

    @Override
    public void notifyCustomers() {
        for (Customer customer: customers) {
            customer.update(this.news);
        }
    }
}

class TEST4{
    public static void main(String[] args) {
        Store store = new Store();
        store.addCustomer(new ConcreteCustomer("JOHN"));
        store.setNews("HHOHOHOHO");
        store.notifyCustomers();
    }
}