package ch03.public5Under;

public class OrderProcessor {
    public boolean placeOrder(int orderId, String productName, int quantity) {
        // 주문을 처리하는 로직: 예시로 간단히 구현
        if (quantity <= 0) {
            throw new IllegalArgumentException("주문 수량은 양수여야 합니다.");
        }
        // 실제로는 데이터베이스에 주문을 저장하는 로직
        System.out.println("주문이 접수되었습니다 - 주문번호: " + orderId);
        return true;
    }

    public boolean cancelOrder(int orderId) {
        // 주문을 취소하는 로직: 예시로 간단히 구현
        // 실제로는 데이터베이스에서 주문을 삭제하는 로직
        System.out.println("주문이 취소되었습니다 - 주문번호: " + orderId);
        return true;
    }
}
