package composite;

import java.util.ArrayList;

abstract class Component{
    protected String name;
    protected String tab = "";

    public Component(String name){
        this.name = name;
    }
    public void add(Component component){}
    public void remove(Component component){}
    public void print(){}
    public ArrayList<Component> getList(){
        return null;
    }
}
class File extends Component{
    public File(String name) {
        super(name);
    }
}
class DirectoryComposite extends Component{
    ArrayList<Component> components = new ArrayList<>();
    public DirectoryComposite(String name) {
        super(name);
    }
    public void add(Component component){
        components.add(component);
    }
    public void remove(Component component){
        components.remove(component);
    }
    @Override
    public ArrayList<Component> getList(){
        return this.components;
    }
    public void print(){
        System.out.println(this.tab + this.name);
        this.tab += "\t";
        for(Component item: this.components){
            if(item.getList() != null){
                item.tab +="\t";
                item.print();
            }
            else System.out.println(this.tab + item.name);
        }
    }
}
class Main{
    public static void main(String[] args) {
        Component fileSystem =new DirectoryComposite("file system");
        Component discC = new DirectoryComposite("disc C");
        fileSystem.add(discC);
        Component docFile = new File("www.doc");
        Component jpgFile = new File("1.jpg");
        discC.add(docFile);
        discC.add(jpgFile);
        fileSystem.print();
    }
}