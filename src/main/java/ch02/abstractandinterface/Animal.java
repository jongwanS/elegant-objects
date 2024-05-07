package ch02.abstractandinterface;

abstract class Animal {
    private String name;
    public Animal(String name) {
        this.name = name;
    }
    public abstract String makeSound();  // 추상 메서드
    public String eat() {
        return name;
    }
}
