package MySpringStudy.core.v3.order;

import MySpringStudy.core.v3.discount.DiscountPolicy;
import MySpringStudy.core.v3.member.Member;
import MySpringStudy.core.v3.member.MemberRepository;

/**
 * 설계 변경으로 OrderServiceImpl에서는 FixDiscountPolicy라는 구현체 대신 discountPolicy라는 인터페이스만 의존함
 * 어떤 구현객체를 주입할지는 AppConfig에서 결정함
 */
public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository ;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
