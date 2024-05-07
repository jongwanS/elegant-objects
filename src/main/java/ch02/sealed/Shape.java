package ch02.sealed;


public sealed class Shape permits Circle {
    private String name;
    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
