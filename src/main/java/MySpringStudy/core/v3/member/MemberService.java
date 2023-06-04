package MySpringStudy.core.v3.member;

public interface MemberService {
    void join(Member member);
    Member findMember(Long memberId);
}
