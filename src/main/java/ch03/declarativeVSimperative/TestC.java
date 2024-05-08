package ch03.declarativeVSimperative;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class TestC {

    @Test
    @DisplayName("static")
    public void staticTest(){
        int k = BetweenStatic.between(5,9,13);
        Assertions.assertEquals(9,k);
    }

    @Test
    @DisplayName("static2")
    public void staticTest2(){
        int k = BetweenStatic.between(new IntegerWithMy0wnAlgorithmStatic(5,9,13));
        Assertions.assertEquals(9,k);
    }

    public void etest3(){
        FilterEven even = new FilterEven(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

}
