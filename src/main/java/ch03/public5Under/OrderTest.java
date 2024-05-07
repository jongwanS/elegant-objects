package ch03.public5Under;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderTest {
    @Test
    public void testPlaceOrder_validOrder() {
        // 유효한 주문을 처리하는지 확인
        int orderId = 1001;
        String productName = "Product A";
        int quantity = 5;
        Order order = new Order(orderId, productName, quantity);
        boolean result = order.placeOrder();
        Assertions.assertTrue(result); // 주문 처리가 성공했는지 확인
    }

    @Test
    public void testPlaceOrder_invalidQuantity() {
        // 잘못된 주문 수량일 때 IllegalArgumentException이 발생하는지 확인
        int orderId = 1002;
        String productName = "Product B";
        int quantity = -1; // 잘못된 수량
        Order order = new Order(orderId, productName, quantity);
        Assertions.assertThrows(IllegalArgumentException.class, () -> order.placeOrder());
    }
}
