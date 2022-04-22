package proxy.labaratory;

interface Image{
    void display();
}
class RealImage implements Image{
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display(){
        System.out.println("Displaying: " + fileName);
    }

    public void loadFromDisk(String name){
        System.out.println("Loading: " + name);
    }
}
class ProxyImage implements Image{
    private RealImage realImage;
    private String fileName;
    public ProxyImage(String fileName){
        this.fileName = fileName;
    }
    @Override
    public void display(){
        if (realImage == null){
            realImage = new RealImage(this.fileName);
        }
        realImage.display();
    }
}
public class ProxyPatternDemo{
    public static void main(String[] args) {
        Image image = new ProxyImage("file.bat");

        image.display();
        System.out.println("");
        image.display();
    }
}
