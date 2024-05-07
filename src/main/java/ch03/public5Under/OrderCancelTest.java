package ch03.public5Under;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderCancelTest {

    @Test
    public void testCancelOrder_validOrder() {
        // 유효한 주문을 취소하는지 확인
        int orderId = 1001;
        OrderCancel orderCancel = new OrderCancel();
        boolean result = orderCancel.cancelOrder(orderId);
        Assertions.assertTrue(result); // 주문 취소가 성공했는지 확인
    }
}