package MySpringStudy.core.member.v1;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
