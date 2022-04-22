package state.labaratory;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.nio.file.*;
import java.util.concurrent.TimeUnit;


class VendingMachine {
    private VendingMachineState state;
    private Map<String, Product> productMap = new HashMap<>();

    public VendingMachine() {
        this.state = new VendingDepositState();
    }

    public void set_state(VendingMachineState state) {
        this.state = state;
    }
    public void pull() {
        Scanner in = new Scanner(System.in);
        int cash = 0;
        String productCode = "";
        if (state instanceof VendingDepositState){
            this.printAvailableProduct();
            System.out.println(">>> INSERT CASH 1$ 2$ 5$ 10$ <<<");
            cash += in.nextInt();
        } else if (state instanceof VendingStockState) {
            Product selectedProduct = null;
            while (selectedProduct == null) {
                System.out.println(">>>  ENTER THE PRODUCT CODE  <<<");
                productCode = in.next();
                if (this.productMap.containsKey(productCode)) {
                    selectedProduct = this.productMap.get(productCode);
                    System.out.println(">>>  PLEASE TAKE YOUR " + selectedProduct.getName().toUpperCase() + "  <<<");
                    System.out.println(">>>  ENTER THE PRODUCT CODE  <<<");
                    System.out.println(">>>    THERE IS YOUR CHANGE  >>> " + (cash - selectedProduct.getPrice()) + " $");
                    try{
                        TimeUnit.SECONDS.sleep(6);
                    } catch (InterruptedException e) {
                        System.out.println(e);;
                    }
                }
            }
        }
        state.pull(this);
    }

    public void addProduct(String code, Product product){
        if(Character.isDigit(code.charAt(1)) && Character.isAlphabetic(code.charAt(0))){
            if (0 < Character.getNumericValue(code.charAt(1)) &&
                Character.getNumericValue(code.charAt(1)) < 5 &&
                'A' <= code.charAt(0) && code.charAt(0) <= 'C'){
                productMap.put(code, product);
            }
        }

    }
    public Product getProduct(String code){
        return productMap.get(code);
    }
    public void delProduct(String code){
        productMap.remove(code);
    }
    public void printAvailableProduct(){
        for (int codePart = 65; codePart < 68; codePart++){
            for(int i=1; i < 5; i++){
                System.out.print("********");
            }
            System.out.print("\n*");
            for(int i=1; i < 5; i++){
                char c = (char) codePart;
                if(this.productMap.containsKey(String.valueOf(c) + i)) {
                    String currentName = getProduct(String.valueOf(c) + i).getName();
                    System.out.print(" " + currentName + " * ");
                }
            }
            System.out.print("\n*");
            for(int i=1; i < 5; i++){
                char c = (char) codePart;
                if(this.productMap.containsKey(String.valueOf(c) + i)) {
                    double price = getProduct(String.valueOf(c) + i).getPrice();
                    System.out.print(String.format(" " + "%.2f", price) + " * ");
                }
            }
            System.out.print("\n*");
            for(int i=1; i < 5; i++){
                char c = (char) codePart;
                System.out.print("  " + String.valueOf(c) + i + "  * ");
            }
            System.out.println();
            }
        for(int i=1; i < 5; i++){
            System.out.print("********");
        }
        System.out.println();
    }
}

interface VendingMachineState {
    void pull(VendingMachine wrapper);
}

class VendingDepositState implements VendingMachineState {
    public void pull(VendingMachine wrapper) {
        wrapper.set_state( new VendingStockState() );
    }  }
class VendingStockState implements VendingMachineState {
    public void pull(VendingMachine wrapper) {
        wrapper.set_state( new VendingDepositState() );
    }
}

class Product{
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String getName(){
        return this.name;
    }
    public double getPrice(){
        return this.price;
    }

    @Override
    public String toString(){
        return this.name + " >> " + Double.toString(this.price) + " $";
    }
}

class ReadFile {
    public void addProductsToVendingMachineFromListInFile(VendingMachine machine) {
        try {
            File myObj = new File(Paths.get(ReadFile.class.getResource(".").toURI()) + "/list.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String[] data = myReader.nextLine().split(" ");
                Product p = new Product(data[2], Double.parseDouble(data[1]));
                machine.addProduct(data[0], p);
            }
            myReader.close();
        } catch (FileNotFoundException | URISyntaxException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

 class StateDemo {
    public static void main( String[] args ) {
        VendingMachine chain = new VendingMachine();
        new ReadFile().addProductsToVendingMachineFromListInFile(chain);
        while (true) {
            chain.pull();
        }
    }
}