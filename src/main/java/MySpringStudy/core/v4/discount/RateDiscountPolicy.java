package MySpringStudy.core.v4.discount;

import MySpringStudy.core.v4.member.Grade;
import MySpringStudy.core.v4.member.Member;

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
