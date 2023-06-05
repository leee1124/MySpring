package MySpringStudy.core.v2;

import MySpringStudy.core.v2.discount.DiscountPolicy;
import MySpringStudy.core.v2.member.MemberRepository;
import MySpringStudy.core.v2.member.MemoryMemberRepository;
import MySpringStudy.core.v2.order.OrderService;
import MySpringStudy.core.v2.member.MemberService;
import MySpringStudy.core.v2.member.MemberServiceImpl;
import MySpringStudy.core.v2.order.OrderServiceImpl;
import MySpringStudy.core.v2.discount.RateDiscountPolicy;


/**
 * AppConfig는 애플리케이션의 전체 동작 방식을 구성하기 위해서, 구현 객체를 생성하고, 연결하는 책임을 가지는 설정 클래스
 *
 * appConfig 객체는 memoryMemberRepository 객체를 생성하고, 그 참조값을 memberServiceImpl을 생성하면서 생성자로 전달
 * 클라이언트인 memberServiceImpl입장에서 보면 의존관계를 외부에서 주입해주는 것
 * 이를 DI(의존관계 주입, 의존성 주입)이라고 함.
 * 요약하면, DI는 외부에서 의존관계를 주입해주는 것을 말함
 */
public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );
    }

    private static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    private static DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
