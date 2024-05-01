package ch02.mock08;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ch08Test {

    @Test
    @DisplayName("df")
    public void adf(){
        Cash dollar = new Cash(new NYSE("secret"), 100);
        Cash euro = dollar.in("EUR");
    }

    @Test
    @DisplayName("페이크객체 NYSE에서 달러와 유료 비율은 1:3 이다.")
    public void fakeNYSE(){
        Cash dollar = new Cash(new Exchange.Fake(), 500);
        Cash euro = dollar.in("EUR");
        Assertions.assertEquals(1500,euro.getCents());
    }

}
