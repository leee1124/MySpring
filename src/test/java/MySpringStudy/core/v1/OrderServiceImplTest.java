package MySpringStudy.core.v1;

import MySpringStudy.core.v1.member.Grade;
import MySpringStudy.core.v1.member.Member;
import MySpringStudy.core.v1.member.MemberService;
import MySpringStudy.core.v1.member.MemberServiceImpl;
import MySpringStudy.core.v1.order.Order;
import MySpringStudy.core.v1.order.OrderService;
import MySpringStudy.core.v1.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderServiceImplTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA", 10000);
        Assertions.assertThat(order.getDiscountPolicy()).isEqualTo(1000);
    }
}