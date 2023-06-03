package MySpringStudy.core.v1.discount;

import MySpringStudy.core.v1.member.Member;

public interface DiscountPolicy {
    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
