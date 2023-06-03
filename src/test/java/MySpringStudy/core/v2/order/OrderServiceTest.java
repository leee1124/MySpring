package MySpringStudy.core.v2.order;

import MySpringStudy.core.v2.member.Grade;
import MySpringStudy.core.v2.member.Member;
import MySpringStudy.core.v2.order.Order;
import MySpringStudy.core.v2.AppConfig;
import MySpringStudy.core.v2.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    /**
     * 테스트 코드에서 @BeforeEach는 각 테스트를 실행하기 전에 호출
     */
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();

    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA", 20000);
        Assertions.assertThat(order.getDiscountPolicy()).isEqualTo(1000);
    }
}