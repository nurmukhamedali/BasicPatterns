interface Image{
    void display();
}
class RealImage implements Image{
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        System.out.println("You're in real Image");
    }

    @Override
    public void display(){
        System.out.println("displaying image...");
    }
}
class ProxyImage implements Image{
    private String filename;
    private RealImage ri;
    public ProxyImage(String filename){
        this.filename = filename;
    }

    @Override
    public void display(){
        if(ri == null){
            ri = new RealImage(this.filename);
        }
        else{
            System.out.println("File from cache");
        }
        ri.display();
    }
}

class ProxyPatternDemo{
    public static void main(String[] args) {
        Image image = new ProxyImage("file.bat");

        image.display();
        System.out.println("");
        image.display();
    }
}