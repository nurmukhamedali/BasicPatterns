package decorator.labaratory;

interface Shape{
    void draw();
}
class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("drawing circle");
    }
}
class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("drawing rectangle");
    }
}
abstract class ShapeDecorator implements Shape{
    Shape shape;
    public ShapeDecorator(Shape shape) {
        this.shape = shape;
    }
}

class RedShapeDecorator extends ShapeDecorator{

    public RedShapeDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        shape.draw();
        setRedBorder(shape);
    }

    public void setRedBorder(Shape shape){
        System.out.println("Border color: red");
    }

}

class TEST3{
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape redCircle = new RedShapeDecorator(new Circle());
        Shape redRect = new RedShapeDecorator(new Rectangle());
        System.out.println("REGULAR CIRCLE: ");
        circle.draw();
        System.out.println("CIRCLE OF RED BORDER");
        redCircle.draw();
        System.out.println("RECTANGLE OF RED BORDER");
        redRect.draw();

    }
}
