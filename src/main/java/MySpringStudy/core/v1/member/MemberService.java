package MySpringStudy.core.v1.member;

import MySpringStudy.core.v1.member.Member;

public interface MemberService {
    void join(Member member);
    Member findMember(Long memberId);
}
