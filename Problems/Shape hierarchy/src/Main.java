//public class Main { // add this class to test output in IDE
//    public static void main(String[] args) {
//        Circle circle = new Circle(10);
//        Triangle triangle = new Triangle(3, 4, 5);
//        Rectangle rectangle = new Rectangle(5, 10);
//
//        System.out.println("Circle perimeter: " + circle.getPerimeter() + " area: " + circle.getArea());
//        System.out.println("Triangle perimeter: " + triangle.getPerimeter() + " area: " + triangle.getArea());
//        System.out.println("Rectangle perimeter: " + rectangle.getPerimeter() + " area: " + rectangle.getArea());
//
//    }
//}

abstract class Shape {

    abstract double getPerimeter();

    abstract double getArea();
}

class Triangle extends Shape {
    double a, b, c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    double getPerimeter() {
        return a + b + c;
    }

    @Override
    double getArea() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s *(s - a)*(s - b)*(s - c));
    }
}

class Rectangle extends Shape {
    double a, b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }


    @Override
    double getPerimeter() {
        return a+a + b+b;
    }

    @Override
    double getArea() {
        return (a*b);
    }
}

class Circle extends Shape {
    double a;

    public Circle(double a) {
        this.a = a;
    }

    @Override
    double getPerimeter() {
        return 2 * Math.PI * a;
    }

    @Override
    double getArea() {
        return Math.PI * a * a;
    }
}

