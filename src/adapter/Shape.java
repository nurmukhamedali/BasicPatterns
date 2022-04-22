package adapter;

class RoundHole{
    private double radius;
    public RoundHole(double radius) {
        this.radius = radius;
    }
    public double getRadius(){
        return this.radius;
    }
    public boolean fits(RoundPeg peg){
        return this.getRadius() >= peg.getRadius();
    }
}
interface Peg{}
class RoundPeg implements Peg{
    private double radius;

    public RoundPeg(double radius) {
        this.radius = radius;
    }
    public double getRadius(){
        return this.radius;
    }
}
class SquarePeg implements Peg{
    private int width;
    public SquarePeg(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }
}
class SquarePegAdapter extends RoundPeg{
    private SquarePeg peg;

    public SquarePegAdapter(SquarePeg peg) {
        super( (peg.getWidth() / 2) * Math.sqrt(2) );
        this.peg = peg;
    }

}
class Fitter extends RoundHole{
    SquarePegAdapter adapter;
    public Fitter(double radius) {
        super(radius);
    }


    public boolean fits(String shape, double value) {
        if (shape == "square"){
            adapter = new SquarePegAdapter(new SquarePeg((int)(value)));
        }
        return super.fits(new RoundPeg(value));
    }
}
class Run{
    public static void main(String[] args) {
        RoundHole hole = new RoundHole(5);
        RoundPeg roundPeg = new RoundPeg(4);
        hole.fits(roundPeg);
    }
}