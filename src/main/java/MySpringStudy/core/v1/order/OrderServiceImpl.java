package MySpringStudy.core.v1.order;

import MySpringStudy.core.v1.discount.DiscountPolicy;
import MySpringStudy.core.v1.discount.FixDiscountPolicy;
import MySpringStudy.core.v1.member.Member;
import MySpringStudy.core.v1.member.MemberRepository;
import MySpringStudy.core.v1.member.MemoryMemberRepository;

/**
 * 주문 생성 요청이 오면, 회원 정보를 조회하고, 할인 정책을 적용한 다음 주문 객체를 생성해서 반환한다.
 * 메모리 회원 리포지토리와 고정금액 할인 정책을 구현체로 생성한다.
 */
public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
