package exercise10;

public class Ellipse extends Figure {
   public Ellipse() {
        super(new Point(0, 0),  1, 1);
    }

    public Ellipse(Point startPoint, double a, double b) {
        super(startPoint, a, b);
    }

    public Ellipse(Ellipse otherEllipse) {
        super(new Point(otherEllipse.startPoint), otherEllipse.side1, otherEllipse.side2);
    }

   @Override
    public double calculatePerimeter() {
        return Math.PI * (3.0 * (side1 + side2) - Math.sqrt((3.0 * side1 + side2) * (side1 + 3.0 * side2)));
    }

    @Override
    public double calculateArea() {
        return Math.PI * side1 * side2;
    }

    @Override
    public String getType() {
        return (side1 == side2) ? "Circle" : "Ellipse";
    }

    @Override
    public boolean equal(Figure figure) {
        boolean sameA = Utils.equals(side1, figure.side1);
        boolean sameB = Utils.equals(side2, figure.side2);
        boolean sameAReversed = Utils.equals(side1, figure.side2);
        boolean sameBReversed = Utils.equals(side2, figure.side1);

        return (sameA && sameB) || (sameAReversed && sameBReversed);
    }

    @Override
    public boolean containsClick(Point click) {
        if ( ((click.getX() - startPoint.getX()) / Math.pow(side1, 2)) -
            ((click.getY() - startPoint.getY()) / Math.pow(side2, 2)) <= 1) {
            return true;
        }
        return false;
    }
}
