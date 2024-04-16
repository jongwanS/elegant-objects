package ch02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Ch2Test {

    @Test
    @DisplayName("Cash constructor without Equals and Hashcode")
    public void cashConstructorWithout(){
        CashWithoutEqualsAndHashCode x = new CashWithoutEqualsAndHashCode(29,95,"USD");
        CashWithoutEqualsAndHashCode y = new CashWithoutEqualsAndHashCode(29,95,"USD");
        Assertions.assertNotEquals(x,y);
    }

    @Test
    @DisplayName("Cash constructor")
    public void cashConstructor(){
        Cash x = new Cash(29,95,"USD");
        Cash y = new Cash(29,95,"USD");
        Assertions.assertEquals(x,y);
    }

    @Test
    @DisplayName("Cash Interface")
    public void cashInterface(){
        Employee employee = new Employee(new DefaultCash());
        Assertions.assertEquals(Integer.MAX_VALUE,employee.toCents());

        Employee employeeUsd = new Employee(new UsdCash());
        Assertions.assertEquals(Integer.MIN_VALUE,employeeUsd.toCents());
    }
}
