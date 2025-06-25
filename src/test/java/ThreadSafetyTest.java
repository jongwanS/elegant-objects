import ch02.Cash;
import ch02.CashThreadSafe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadSafetyTest {

    @Test
    @DisplayName("가변객체는 스레드 안정성이 보장되지 않는다.")
    public void threadSafety() throws InterruptedException {
        final int DOLLARS = 10;
        final int CENTS = 50;
        final CashThreadSafe cash = new CashThreadSafe(DOLLARS, CENTS);
        Thread thread1 = new Thread(() -> {
            cash.mul(2);
        });
        Thread thread2 = new Thread(() -> {
            cash.mul(3);
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        Assertions.assertEquals(DOLLARS*2*3,cash.getDollars());
        Assertions.assertEquals(CENTS *2*3,cash.getCents());
    }

    @Test
    @DisplayName("불변객체는 스레드 안정성이 보장된다.")
    public void threadSafety2() throws InterruptedException {
        final int DOLLARS = 10;
        final int CENTS = 50;
        final Cash cash = new Cash(DOLLARS, CENTS,"USD");
        Thread thread1 = new Thread(() -> {
            cash.mul(2);
        });
        Thread thread2 = new Thread(() -> {
            cash.mul(3);
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        Assertions.assertEquals(DOLLARS,cash.getDigits());
        Assertions.assertEquals(CENTS,cash.getCents());
    }

    @Test
    @DisplayName("가변객체는 스레드 안정성이 보장되지 않는다..")
    public void ttt(){
        final CashThreadSafe cash = new CashThreadSafe(15, 10);
        final CountDownLatch start = new CountDownLatch(1);//특정 수의 이벤트가 발생할 때까지 스레드를 대기시키는 데 사용
        final Callable<Object> script = () -> {
            start.await(); // 카운트다운 이벤트를 기다린다.
            cash.mul(2);
            System.out.println(cash.toString());
            return null;
        };
        final ExecutorService svc = Executors.newCachedThreadPool();
        svc.submit(script);// 첫 번째 스레드
        svc.submit(script);// 두 번째 스레드
        start.countDown();
    }
}
