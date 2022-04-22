package strategy;

import java.util.ArrayList;

interface PaymentStrategy{
    void pay(int amount);
}
class CreditCardStrategy implements PaymentStrategy {
    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpire;
    public CreditCardStrategy(String name, String cardNumber, String cvv, String dateOfExpire){
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.dateOfExpire = dateOfExpire;
    }

    @Override
    public void pay(int amount){
        System.out.println(amount + " paid with credit/debit card");
    }
}
class KaspiStrategy implements PaymentStrategy {
    private String emailId;
    private String password;

    public KaspiStrategy(String emailId, String password){
        this.emailId = emailId;
        this.password = password;
    }

    public void pay(int amount){
        System.out.println(amount + " paid using Kaspi.kz");
    }
}
class Item{
    private int price;
    private String name;
    private String barcode;
    public Item(String barcode, int price){
        this.barcode = barcode;
        this.price = price;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getPrice(){
        return this.price;
    }
}
class ShoppingCart{
    private ArrayList<Item> items;
    public ShoppingCart(){
        this.items = new ArrayList<>();
    }
    public void addItem(Item item){
        this.items.add(item);
    }
    public void removeItem(Item item){
        this.items.remove(item);
    }
    public int calculateTotal(){
        int sum = 0;
        for(Item item: items){
            sum += item.getPrice();
        }
        return sum;
    }
    public void pay(PaymentStrategy payment){
        int amount = calculateTotal();
        payment.pay(amount);
    }
}
class ShoppingCartTest{
    public static void main(String[] args){
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Item("0101", 1000));
        cart.addItem(new Item("0110", 1000));

        cart.pay(new KaspiStrategy("77476301200", "jlkjkl"));
        cart.pay(new CreditCardStrategy("Ali", "4455 4455 4455 4455", "123", "10/24"));

    }
}
