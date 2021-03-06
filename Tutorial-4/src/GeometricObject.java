import java.util.ArrayList;
import java.util.Scanner;

public abstract class GeometricObject {
    protected boolean filled;
    protected String color;

    GeometricObject() {
    }

    GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract double getPerimeter();

    public abstract double getArea();

    public abstract String getShape();

    @Override
    public String toString() {
        return "GeometricObject{" +
                "filled=" + filled +
                ", color='" + color + '\'' +
                '}';
    }
}

class Circle extends GeometricObject {
    protected double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return Math.round(2 * Math.PI * this.radius);
    }

    @Override
    public double getArea() {
        return Math.round(Math.PI * Math.pow(this.radius, 2));
    }

    @Override
    public String getShape() {
        return "Circle";
    }

    @Override
    public String toString() {
        return "Circle{" +
                "filled=" + filled +
                ", color='" + color + '\'' +
                ", radius=" + radius +
                '}';
    }


}

class Rectangle extends GeometricObject {
    protected double length;
    private double width;

    public Rectangle() {
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public Rectangle(String color, boolean filled, double length, double width) {
        super(color, filled);
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double getPerimeter() {
        return Math.round((2 * length) + (2 * width));
    }

    @Override
    public double getArea() {
        return Math.round(this.length * this.width);
    }

    @Override
    public String getShape() {
        return "Rectangle";
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "filled=" + filled +
                ", color='" + color + '\'' +
                ", length=" + length +
                ", width=" + width +
                '}';
    }


}

class Square extends GeometricObject {
    protected double side;

    public Square() {
    }

    public Square(double side) {
        this.side = side;
    }

    public Square(String color, boolean filled, double side) {
        super(color, filled);
        this.side = side;
    }

    @Override
    public double getPerimeter() {
        return Math.round(4 * this.side);
    }

    @Override
    public double getArea() {
        return Math.round(Math.pow(side, 2));
    }

    @Override
    public String getShape() {
        return "Square";
    }


}

interface ShapeCollection {

    void addShape(GeometricObject shape);

    void printShapeList();

    boolean runMenu();

}

class GeometricShapeCollection implements ShapeCollection {
    private ArrayList<GeometricObject> shapeList;
    private int numObject;

    public GeometricShapeCollection(int listLength) {
        this.numObject = listLength;
        shapeList = new ArrayList<GeometricObject>();
    }

    @Override
    public void addShape(GeometricObject shape) {
        if (this.shapeList.size() < this.numObject) {
            this.shapeList.add(shape);
        } else {
            System.out.println("No more space in the list");
        }
    }

    @Override
    public void printShapeList() {
        for (int i = 0; i < shapeList.size(); i++) {
            if (shapeList.get(i).getShape().equals("Circle")) {
                System.out.println("Shape = Circle, Area = " +
                        shapeList.get(i).getArea() + ", Perimeter = " + shapeList.get(i).getPerimeter());

            }
        }
    }

    @Override
    public boolean runMenu() {
        boolean exit = false;
        System.out.println("To Add a new shape press 1");
        System.out.println("To print the list of the shapes press 2");
        System.out.println("To exit press 3");
        Scanner s = new Scanner(System.in);
        int choice = s.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Press 1 if you want to add a Circle");
                System.out.println("Press 2 if you want to add a Rectangle");
                System.out.println("Press 3 if you want to add a Square");
                int choice2 = s.nextInt();
                s.nextLine();
                System.out.println("Enter the color of your shape");
                String colour = s.nextLine();

                System.out.println("Is it filled? (y/n)");
                String isFilled = s.nextLine();
                boolean filled = false;
                if (isFilled.equals("y"))
                    filled = true;
                else if (isFilled.equals("n"))
                    filled = false;
                else
                    System.out.println("Please enter y or n, if the shape is filled or not respectively");

                switch (choice2) {
                    case 1:

                        System.out.println("Insert the radius");

                        int radius = s.nextInt();
                        Circle c = new Circle(radius, colour, filled);
                        this.addShape(c);
                        break;
                    case 2:
// write here the code if the rectangle is selected
                    case 3:
// write here the code if the square is selected
                }
                break;
            case 2:

                this.printShapeList();

                break;
            case 3:
                exit = true;
                break;

        }
        return exit;
    }

    public static void main(String[] args) {
        ShapeCollection sys = new GeometricShapeCollection(10);
        boolean exit = false;
        while (!exit) {
            exit = sys.runMenu();
        }
    }
}