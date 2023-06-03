package MySpringStudy.core.member.v1;

import MySpringStudy.core.member.v1.Grade;
import MySpringStudy.core.member.v1.Member;
import MySpringStudy.core.member.v1.MemberService;
import MySpringStudy.core.member.v1.MemberServiceImpl;
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