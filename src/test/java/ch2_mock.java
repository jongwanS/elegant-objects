import ch02.mock08.Cash;
import ch02.mock08.Exchange;
import ch02.mock08.NYSE;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ch2_mock {

    @Test
    @DisplayName("페이크객체 NYSE에서 달러와 유료 비율은 1:3 이다.")
    public void fakeNYSE(){
        Cash dollar = new Cash(new Exchange.Fake(), 500);
        Cash euro = dollar.in("EUR");
        Assertions.assertEquals(1500,euro.getCents());
    }

    @Test
    @DisplayName("페이크객체 NYSE에서 달러와 유료 비율은 1:4 이다.")
    public void fakeNYSE2(){
        Cash dollar = new Cash(new Exchange.Fake(), 500);
        Cash euro = dollar.in();
        Assertions.assertEquals(2000,euro.getCents());
    }

    @Test
    @DisplayName("mock 객체")
    public void mokito(){
        Exchange exchange = Mockito.mock(Exchange.class);
        Mockito.doReturn(1.15)
                .when(exchange)
                .rate("USD", "EUR");

        Cash cash = new Cash(exchange, 300);
        Cash euro = cash.in("EUR");
        Assertions.assertEquals(345,euro.getCents());
    }

    @Test
    @DisplayName("mock 객체 USD 하나")
    public void mokitoUSD(){
        Exchange exchange = Mockito.mock(Exchange.class);
        Mockito.doReturn(1.15)
                .when(exchange)
                .rate("USD");

        Cash cash = new Cash(exchange, 300);
        Cash euro = cash.in();
        Assertions.assertEquals(345,euro.getCents());
    }
}
