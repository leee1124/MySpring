package MySpringStudy.core.v4;

import MySpringStudy.core.v4.discount.DiscountPolicy;
import MySpringStudy.core.v4.discount.RateDiscountPolicy;
import MySpringStudy.core.v4.member.MemberRepository;
import MySpringStudy.core.v4.member.MemberService;
import MySpringStudy.core.v4.member.MemberServiceImpl;
import MySpringStudy.core.v4.member.MemoryMemberRepository;
import MySpringStudy.core.v4.order.OrderService;
import MySpringStudy.core.v4.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Configuration 애너테이션은 AppConfig클래스를 설정을 구성한다는 의미이다.
 * 각 메서드에 @Bean 애너테이션을 붙이면 스프링 컨테이너에 스프링 빈으로 등록된다.
 */

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );
    }

    @Bean
    public MemberRepository memberRepository() {

        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
