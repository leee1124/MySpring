package MySpringStudy.core.v1.discount;

import MySpringStudy.core.v1.member.Grade;
import MySpringStudy.core.v1.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {
    private final int discountFixAmount = 1000; // 1000원 할인


    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return discountFixAmount;//VIP면 1000원 할인
        }else{
            return 0;   //아니면 할인 없음
        }
    }
}
