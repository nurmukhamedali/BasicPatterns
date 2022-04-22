package decorator;

interface Tree{
    String decorate();
}
class ChristmasTree implements Tree {

    @Override
    public String decorate(){
        return "Christmas Tree";
    }
}
abstract class TreeDecorator implements Tree {
    private Tree tree;

    public TreeDecorator(Tree tree) {
        this.tree = tree;
    }

    @Override
    public String decorate(){
        return tree.decorate();
    }
}
class BubbleLights extends TreeDecorator {
    public BubbleLights(Tree tree){
        super(tree);
    }
    @Override
    public String decorate(){
        return super.decorate() + ", with Bubble Lights";
    }
}
class Garland extends TreeDecorator {
    public Garland(Tree tree){
        super(tree);
    }
    @Override
    public String decorate(){
        return super.decorate() + ", with Garland";
    }
}
class Testing{
    public static void main(String[] args){
        Tree tree = new ChristmasTree();
        String s0 = tree.decorate();
        System.out.println(s0);
        tree = new BubbleLights(tree);
        String s1 = tree.decorate();
        System.out.println(s1);
        tree = new Garland(tree);
        String s2 = tree.decorate();
        System.out.println(s2);
    }
}
