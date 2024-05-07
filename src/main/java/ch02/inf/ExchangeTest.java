package ch02.inf;

import ch02.CashIdentityMutability;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExchangeTest {

    @Test
    @DisplayName("나쁜 인터페이스 : 여러개의 public 메서드를 노출시킨다")
    public void badExchangeTest(){
        ExchangeBad bad = new YAHOO_BAD();
        Assertions.assertEquals(1.0F,bad.rate("USD"));
        Assertions.assertEquals(1.3F,bad.rate("EUR","USD"));
    }

    @Test
    @DisplayName("나쁜 인터페이스 : override 강제성이 생긴다." +
            "각 구현체마다 특정 기능이 필요 없을수도 있기 때문이다.")
    public void badExchangeTest2(){
        ExchangeBad bad = new NYSE_BAD();
        Assertions.assertThrows(RuntimeException.class,()-> {
            bad.rate("EUR","USD");
        });
    }

    @Test
    @DisplayName("좋은 인터페이스 : 최대한 응집도를 높인다.")
    public void exchangeTest(){
        Exchange.Smart good = new Exchange.Smart(new YAHOO());
        Assertions.assertEquals(1.3F,good.eurToUsd());
    }

    @Test
    @DisplayName("좋은 인터페이스 : override를 강제하지 않는다.")
    public void exchangeTest2(){
        Exchange.Smart good = new Exchange.Smart(new NYSE());
        Assertions.assertThrows(RuntimeException.class,()->{
            good.eurToUsd();
        });
    }

    @Test
    @DisplayName("공통 기능을 추출하고 코드 중복을 피할 수 있다.")
    public void exchangeTestDecorator(){
        Exchange.Fast fast = new Exchange.Fast(new NYSE());
        Assertions.assertEquals(1F,fast.rate("USD","USD"));
    }
}
