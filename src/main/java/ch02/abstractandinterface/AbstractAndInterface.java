package ch02.abstractandinterface;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AbstractAndInterface {

    @Test
    @DisplayName("abstarct test")
    public void abstractTest(){
        Animal animal = new Dog("개");
        Assertions.assertEquals("개",animal.eat());
        Assertions.assertEquals("멍멍",animal.makeSound());
    }

    @Test
    @DisplayName("interface test")
    public void interfaceTest(){
        Vehicle vehicle = new Tico();
        //java 8 부터 추가
        Assertions.assertEquals("공통이닷",vehicle.commonVehicle());
    }
}
