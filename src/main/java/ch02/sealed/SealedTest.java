package ch02.sealed;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SealedTest {

    @Test
    @DisplayName("sealed class")
    public void sealedClass(){
        Shape shape = new Circle(123);
        Assertions.assertAll(
                () -> assertEquals("똥글이",shape.getName()),
                () -> assertEquals(Math.PI * 123 * 123,((Circle) shape).getArea())
        );
    }

    @Test
    @DisplayName("sealed interface")
    public void sealedInterface(){
        Shape shape = new Circle(123);
        Assertions.assertAll(
                () -> assertEquals("똥글이",shape.getName()),
                () -> assertEquals(Math.PI * 123 * 123,((Circle) shape).getArea())
        );
    }
}
