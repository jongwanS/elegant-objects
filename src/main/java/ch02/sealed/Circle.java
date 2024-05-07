package ch02.sealed;

final class Circle extends Shape {
    private double radius;
    public Circle(double radius) {
        super("똥글이");
        this.radius = radius;
    }
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
