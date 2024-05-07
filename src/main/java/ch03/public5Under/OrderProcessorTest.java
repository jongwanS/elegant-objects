package ch03.public5Under;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderProcessorTest {

    @Test
    public void testPlaceOrder_validOrder() {
        // 주문이 제대로 처리되는지 확인
        OrderProcessor processor = new OrderProcessor();
        int orderId = 1001;
        String productName = "Product A";
        int quantity = 5;
        boolean result = processor.placeOrder(orderId, productName, quantity);
        Assertions.assertTrue(result); // 주문 처리가 성공했는지 확인
    }

    @Test
    public void testPlaceOrder_invalidQuantity() {
        // 잘못된 주문 수량일 때 IllegalArgumentException이 발생하는지 확인
        OrderProcessor processor = new OrderProcessor();
        int orderId = 1002;
        String productName = "Product B";
        int quantity = -1; // 잘못된 수량
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> processor.placeOrder(orderId, productName, quantity));
    }

    @Test
    public void testCancelOrder_validOrder() {
        // 주문 취소가 제대로 처리되는지 확인
        OrderProcessor processor = new OrderProcessor();
        int orderId = 1003;
        boolean result = processor.cancelOrder(orderId);
        Assertions.assertTrue(result); // 주문 취소가 성공했는지 확인
    }
}
