package MySpringStudy.core.member.v1;

public interface MemberService {
    void join(Member member);
    Member findMember(Long memberId);
}
