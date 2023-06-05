package MySpringStudy.core.v1;

import MySpringStudy.core.v1.discount.DiscountPolicy;
import MySpringStudy.core.v1.member.Grade;
import MySpringStudy.core.v1.member.Member;
import MySpringStudy.core.v1.discount.RateDiscountPolicy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateDiscountPolicyTest {
    DiscountPolicy discountPolicy = new RateDiscountPolicy();
    @Test
    @DisplayName("VIP는 10% 할인")
    void discount() {
        //given
        Member member = new Member(1L,"memberA", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member,10000);
        //then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인 안들어감")
    void vip아님() {
        //given
        Member member = new Member(1L,"memberA", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member,10000);
        //then
        Assertions.assertThat(discount).isEqualTo(0);
    }
}