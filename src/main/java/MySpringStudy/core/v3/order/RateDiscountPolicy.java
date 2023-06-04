package MySpringStudy.core.v3.order;

import MySpringStudy.core.v3.discount.DiscountPolicy;
import MySpringStudy.core.v3.member.Grade;
import MySpringStudy.core.v3.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {
    private int discountPercent = 10; //10% 할인
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * discountPercent / 100;
        }
        return 0;
    }
}
