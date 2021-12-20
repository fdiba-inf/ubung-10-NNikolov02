package exercise10;

public class Ellipse extends Figure {
    
    public Ellipse() {
    super(new Point(0, 0),  1, 1);
    }

    public Ellipse(Point startPoint, double a, double b) {
      super(startPoint ,a ,b);
         }

    public Ellipse(Ellipse otherEllipse) {
        
        super(otherEllipse.startPoint , otherEllipse.side1 , otherEllipse.side2);
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
        double clickX = click.getX();
        double clickY = click.getY();

        double centerX = startPoint.getX();
        double centerY = startPoint.getY();

        double part1 = (clickX - centerX) * (clickX - centerX) / (side1 * side1);
        double part2 = (clickY - centerY) * (clickY - centerY) / (side2 * side2);

        return (part1 + part2) <= 1;
    }
}
      