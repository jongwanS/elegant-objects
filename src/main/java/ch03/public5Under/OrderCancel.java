package ch03.public5Under;

public class OrderCancel {
    private int orderId;
    public boolean cancelOrder(int orderId) {
        // 주문을 취소하는 로직: 예시로 간단히 구현
        // 실제로는 데이터베이스에서 주문을 삭제하는 로직
        System.out.println("주문이 취소되었습니다 - 주문번호: " + orderId);
        return true;
    }
}
