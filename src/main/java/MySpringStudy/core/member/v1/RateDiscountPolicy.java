package MySpringStudy.core.member.v1;

public class RateDiscountPolicy implements DiscountPolicy{
    private int discountPercent = 10; //10% 할인
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * discountPercent / 100;
        }
        return 0;
    }
}
