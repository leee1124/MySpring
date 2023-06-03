package MySpringStudy.core.v1;

import MySpringStudy.core.v1.member.Grade;
import MySpringStudy.core.v1.member.Member;
import MySpringStudy.core.v1.member.MemberService;
import MySpringStudy.core.v1.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MemberServiceImplTest {

    MemberService memberService = new MemberServiceImpl();
    @Test
    void join() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }

}