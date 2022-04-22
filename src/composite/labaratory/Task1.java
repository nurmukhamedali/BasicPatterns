package composite.labaratory;


import java.util.ArrayList;

abstract class Employee{
    protected String tab = "";
    public abstract int getId();
    public abstract String getName();
    public abstract double getSalary();
    public abstract void print();
    void add(Employee employee){}
    void remove(Employee employee){}
    Employee getChild(int id){
        return null;
    }
    ArrayList<Employee> getList(){
        return null;
    }
}


class Accountant extends Employee{
    int id;
    String name;
    double salary;

    public Accountant(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getSalary() {
        return 0;
    }

    @Override
    public void print() {

    }
}

class Cashier extends Employee{
    int id;
    String name;
    double salary;

    public Cashier(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public void print() {

    }
}

class BankManager extends Employee{
    ArrayList<Employee> employees = new ArrayList<>();
    int id;
    String name;
    double salary;

    public BankManager(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public ArrayList<Employee> getList() {
        return this.employees;
    }

    @Override
    public void print() {
        System.out.println(this.tab + this.getClass().getSimpleName() + ": " + this.name + " => ");
        this.tab += "\t";
        for(Employee item: this.employees){
            if(item.getList() != null){
                item.tab +="\t";
                item.print();
            }
            else System.out.println(tab + item.getClass().getSimpleName() + ": " + item.getName());
        }
    }

    @Override
    public void add(Employee employee) {
        this.employees.add(employee);
    }

    @Override
    public void remove(Employee employee) {
        this.employees.add(employee);
    }

    @Override
    public Employee getChild(int id) {
        for (Employee e: this.employees) {
            if(e.getId() == id){
                return e;
            }
        }
        return null;
    }
}

class Main{
    public static void main(String[] args) {
        Employee topManager = new BankManager(1, "Hurry", 505050);
        Employee officeManager = new BankManager(2,"Tico", 303030);
        Employee registerManager = new BankManager(3, "Artur", 303030);
        topManager.add(officeManager);
        topManager.add(registerManager);
        Employee accountant1 = new Accountant(115, "Nick", 202020);
        Employee accountant2 = new Accountant(115, "Nick", 202020);
        officeManager.add(accountant1);
        officeManager.add(accountant2);
        Employee cashier1 = new Cashier(10000, "Ella", 101010);
        Employee cashier2 = new Cashier(10000, "Rodrigo", 101010);
        registerManager.add(cashier1);
        registerManager.add(cashier2);
        topManager.print();
    }
}
