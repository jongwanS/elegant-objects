package ch02.abstractandinterface;

public class Dog extends Animal{
    public Dog(String name) {
        super(name);
    }
    @Override
    public String makeSound() {
        return "멍멍";
    }
}
