package MySpringStudy.core.v4.discount;

import MySpringStudy.core.v4.member.Member;

public interface DiscountPolicy {
    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
