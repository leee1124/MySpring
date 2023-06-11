package MySpringStudy.core.v5.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
