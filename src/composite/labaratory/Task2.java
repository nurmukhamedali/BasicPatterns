package composite.labaratory;


import java.util.ArrayList;

abstract class Product{
    protected int id;
    protected String name;
    protected String tab = "";
    public abstract int getId();
    public abstract String getName();
    public abstract void print();
    void add(Product product){}
    void remove(Product product){}
    Product getChild(int id){
        return null;
    }
    ArrayList<Product> getList(){
        return null;
    }
}


class ConcreteProduct extends Product{

    public ConcreteProduct(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public void print() {

    }
}

class Box extends Product{
    ArrayList<Product> products = new ArrayList<>();
    int id;
    String name;

    public Box(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public ArrayList<Product> getList() {
        return this.products;
    }

    @Override
    public void print() {
        System.out.println(this.tab + this.getClass().getSimpleName() + ": " + this.name + " => ");
        this.tab += "\t";
        for(Product item: this.products){
            if(item.getList() != null){
                item.tab +="\t";
                item.print();
            }
            else System.out.println(tab + item.getClass().getSimpleName() + ": " + item.getName());
        }
    }

    @Override
    public void add(Product product) {
        this.products.add(product);
    }

    @Override
    public void remove(Product product) {
        this.products.add(product);
    }

    @Override
    public Product getChild(int id) {
        for (Product e: this.products) {
            if(e.getId() == id){
                return e;
            }
        }
        return null;
    }
}

class TASK2{
    public static void main(String[] args) {
        Product topBox = new Box(1, "Hurry");
        Product box1 = new Box(2,"Tico");
        Product box2 = new Box(3, "Artur");
        topBox.add(box1);
        topBox.add(box2);
        Product product0 = new ConcreteProduct(115, "Mouse");
        Product product3 = new ConcreteProduct(115, "Mirror");
        box1.add(product0);
        box1.add(product3);
        Product product1 = new ConcreteProduct(10000, "Headphone");
        Product product2 = new ConcreteProduct(10000, "Phone");
        box2.add(product1);
        box2.add(product2);
        topBox.print();
    }
}
