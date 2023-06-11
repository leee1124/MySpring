package MySpringStudy.core.v5.discount;

import MySpringStudy.core.v5.member.Member;

public interface DiscountPolicy {
    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
